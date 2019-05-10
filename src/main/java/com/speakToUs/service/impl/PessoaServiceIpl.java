package com.speakToUs.service.impl;

import com.speakToUs.dao.PessoaDao;
import com.speakToUs.model.Pessoa;
import com.speakToUs.service.PessoaService;
import com.speakToUs.util.GerarSenha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


@Service(value = "pessoaService")
public class PessoaServiceIpl implements PessoaService {

    @Autowired
    private PessoaDao pessoaDao;

    @Override
    public void save(Pessoa pessoa) {
        pessoa.setSenha(GerarSenha.senhaMD5(pessoa.getSenha()));
        Date dtToday = new Date();
        pessoa.setDtCadastro(new Date());
        pessoaDao.save(pessoa);
    }
}
