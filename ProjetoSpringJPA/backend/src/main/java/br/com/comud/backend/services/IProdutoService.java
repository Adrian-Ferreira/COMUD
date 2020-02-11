package br.com.comud.backend.services;

import java.util.List;

import br.com.comud.backend.models.Produto;

public interface IProdutoService {
	public void create(Produto p);
	public Produto readById (int idProduto);
	public void update(Produto p);
	public List<Produto> readAllDesc();
	public boolean existsById(int idProduto);
	public List<Produto> buscarPorPalavraChave(String palavra);
}
