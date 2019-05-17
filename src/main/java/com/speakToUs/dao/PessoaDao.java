package com.speakToUs.dao;

import com.speakToUs.model.Pessoa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PessoaDao extends CrudRepository<Pessoa, Integer> {

    //@Query("select c from Cidade c where c.ibge = ?1")
    //public Cidade findCidadeByIdIbge(String id);

    @Query("select p from Pessoa p where p.email = ?1")
    public Pessoa findPessoaByEmail(String email);

}
