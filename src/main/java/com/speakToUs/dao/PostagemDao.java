package com.speakToUs.dao;

import com.speakToUs.model.Postagem;
import com.speakToUs.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostagemDao extends CrudRepository<Postagem, Long> {

    @Query("select p from Postagem p where p.usuario = ?1")
    List<Postagem> findForUser(Long usuario);
}
