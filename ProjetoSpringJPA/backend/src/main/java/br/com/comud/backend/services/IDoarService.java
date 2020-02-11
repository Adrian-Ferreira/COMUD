package br.com.comud.backend.services;

import br.com.comud.backend.models.Doacao;

public interface IDoarService {
	public void create(Doacao d);
	public Doacao readById (int idDoacao);
	public boolean existsById(int idDoacao);
}
