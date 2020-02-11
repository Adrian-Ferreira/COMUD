package br.com.comud.backend.services;

import java.util.List;

import br.com.comud.backend.models.Ong;

public interface IOngService {
	public void create(Ong ong);
	public Ong readById (int idOng);
	public void update(Ong ong);
	public List<Ong> readAll();
	public boolean existsById(int idOng);
}
