package br.com.comud.backend.daos;

import org.springframework.data.repository.CrudRepository;

import br.com.comud.backend.models.Ong;

public interface IOngDB extends CrudRepository<Ong, Integer>{

}
