package com.speakToUs.controller;

import com.speakToUs.config.JwtTokenUtil;
import com.speakToUs.model.*;
import com.speakToUs.service.PessoaService;
import com.speakToUs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return new ApiResponse<>(200, "success",token,token);

    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public RetornoPadrao novoUsuario(@RequestBody Pessoa pessoa) throws AuthenticationException{
        try {
            Pessoa pessoaSalva = new Pessoa();
            pessoaSalva = pessoaService.save(pessoa);
            return new RetornoPadrao(200, "success",pessoa);
        }catch (Exception ex){
            return null;
        }


    }
}

class RetornoPadrao{

    private int status;
    private String message;
    private Pessoa pessoa;

    public RetornoPadrao(int status, String message, Pessoa pessoa) {
        this.status = status;
        this.message = message;
        this.pessoa = pessoa;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}