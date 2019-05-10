package com.speakToUs.dao;

import com.speakToUs.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaDao extends CrudRepository<Pessoa, Integer> {
}
