package br.com.comud.backend.services;

import br.com.comud.backend.models.Troca;

public interface ITrocaService{
    public void create(Troca t);
    public Troca readById (int idTroca);
    public boolean existsById(int idTroca);
}
