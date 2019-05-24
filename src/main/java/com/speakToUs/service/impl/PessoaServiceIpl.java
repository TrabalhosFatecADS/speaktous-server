package com.speakToUs.service.impl;

import com.speakToUs.dao.PessoaDao;
import com.speakToUs.dao.UserDao;
import com.speakToUs.model.Pessoa;
import com.speakToUs.model.User;
import com.speakToUs.service.PessoaService;
import com.speakToUs.util.GerarSenha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


@Service(value = "pessoaService")
public class PessoaServiceIpl implements PessoaService {

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private PessoaDao pessoaDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Pessoa save(Pessoa pessoa) {
        if (pessoaDao.findPessoaByEmail(pessoa.getEmail()) == null) {
            String senha = pessoa.getSenha();
            pessoa.setSenha(GerarSenha.senhaMD5(pessoa.getSenha()));
            Date dtToday = new Date();
            pessoa.setDtCadastro(new Date());
            pessoaDao.save(pessoa);


            User newUser = new User();
            newUser.setPassword(bcryptEncoder.encode(senha));
            newUser.setUsername(pessoa.getEmail());
            userDao.save(newUser);


            return pessoa;
        }else{
            return null;
        }
    }
}
