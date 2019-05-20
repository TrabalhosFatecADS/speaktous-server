package com.speakToUs.service;

import com.speakToUs.model.Postagem;
import com.speakToUs.model.Usuario;

import java.util.List;

public interface PostagemService {

    Postagem save(Postagem postagem);
    List<Postagem> findForUser(Long usuario);
    void delete(Postagem postagem);
    Postagem findById(Long id);

}
