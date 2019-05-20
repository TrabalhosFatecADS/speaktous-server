package com.speakToUs.service.impl;

import com.speakToUs.dao.PostagemDao;
import com.speakToUs.model.Postagem;
import com.speakToUs.model.Usuario;
import com.speakToUs.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "PostagemService")
public class PostagemServiceImpl implements PostagemService {

    @Autowired
    private PostagemDao postagemDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public Postagem save(Postagem postagem) {

        return postagemDao.save(postagem);
    }

    @Override
    public List<Postagem> findForUser(Long usuario) {

        return postagemDao.findForUser(usuario);
    }

    @Override
    public void delete(Postagem postagem) {

    }

    @Override
    public Postagem findById(Long id) {
        return null;
    }
}
