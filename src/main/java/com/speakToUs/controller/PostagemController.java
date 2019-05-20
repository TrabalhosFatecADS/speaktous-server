package com.speakToUs.controller;


import com.speakToUs.model.ApiResponse;
import com.speakToUs.model.Postagem;
import com.speakToUs.model.User;
import com.speakToUs.model.Usuario;
import com.speakToUs.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/postagemw")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @PostMapping
    public ApiResponse<Postagem> saveUser(@RequestBody Postagem post){
        return new ApiResponse<>(HttpStatus.OK.value(), "postagem salvo com sucesso.",postagemService.save(post),"");
    }

    @GetMapping("/{usuario}")
    public ApiResponse<List<Postagem>> listPost(@PathVariable Long usuario){
        return new ApiResponse<>(HttpStatus.OK.value(), "lista de postagens recuperada com sucesso.",postagemService.findForUser(usuario),"XXXXXXXX");
    }
}
