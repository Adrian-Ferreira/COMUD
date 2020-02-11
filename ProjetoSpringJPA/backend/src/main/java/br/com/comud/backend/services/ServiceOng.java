package br.com.comud.backend.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.comud.backend.daos.IOngDB;
import br.com.comud.backend.models.Ong;


@Component
public class ServiceOng implements IOngService{

	@Autowired
	IOngDB repo;
	
	@Override
	public void create(Ong ong) {
		// TODO Auto-generated method stub
		repo.save(ong);
	}

	@Override
	public Ong readById(int idONG) {
		// TODO Auto-generated method stub
		return repo.findById(idONG).get();
	}

	@Override
	public void update(Ong ong) {
		// TODO Auto-generated method stub
		repo.save(ong);
	}

	@Override
	public boolean existsById(int idONG) {
		// TODO Auto-generated method stub
		return repo.existsById(idONG);
	}
	
	@Override
	public List<Ong> readAll() {
		// TODO Auto-generated method stub
		return (List<Ong>)repo.findAll();
	}
	
	

}
