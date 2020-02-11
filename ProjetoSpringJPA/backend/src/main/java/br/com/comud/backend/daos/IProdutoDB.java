package br.com.comud.backend.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.comud.backend.models.Produto;

public interface IProdutoDB extends CrudRepository<Produto, Integer>{
	public List<Produto> findAllByOrderByIdProdutoDesc();
	public List<Produto> findAllByDetalhesContains(String detalhes);
}
