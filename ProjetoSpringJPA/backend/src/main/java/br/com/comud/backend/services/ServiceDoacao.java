package br.com.comud.backend.services;

import br.com.comud.backend.daos.IDoarDB;
import br.com.comud.backend.models.Doacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceDoacao implements IDoarService{
    @Autowired
    IDoarDB repo;

    @Override
    public void create(Doacao d) {
        repo.save(d);
    }

    @Override
    public Doacao readById(int idDoacao) {
        return repo.findById(idDoacao).get();
    }

    @Override
    public boolean existsById(int idDoacao) {
        return repo.existsById(idDoacao);
    }
    

}
