package br.com.comud.backend.services;

import br.com.comud.backend.daos.ITrocaDB;
import br.com.comud.backend.models.Troca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceTroca implements ITrocaService{
    @Autowired
    ITrocaDB repo;

    @Override
    public void create(Troca t) {
        repo.save(t);
    }

    @Override
    public Troca readById(int idTroca) {
        return repo.findById(idTroca).get();
    }

	@Override
	public boolean existsById(int idTroca) {
		return repo.existsById(idTroca);
	}

}
