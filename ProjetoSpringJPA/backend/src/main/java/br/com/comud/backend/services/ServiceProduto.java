package br.com.comud.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.comud.backend.daos.IProdutoDB;
import br.com.comud.backend.models.Produto;

@Component
public class ServiceProduto implements IProdutoService{

	@Autowired
	IProdutoDB repo;
	
	@Override
	public void create(Produto p) {
		// TODO Auto-generated method stub
		repo.save(p);
		}

	@Override
	public Produto readById(int idProduto) {
		// TODO Auto-generated method stub
		return repo.findById(idProduto).get();
		}

	@Override
	public void update(Produto p) {
		// TODO Auto-generated method stub
		repo.save(p);
		}

	@Override
	public List<Produto> readAllDesc() {
		// TODO Auto-generated method stub
		return (List<Produto>)repo.findAllByOrderByIdProdutoDesc();
	}


	@Override
	public boolean existsById(int idProduto) {
		// TODO Auto-generated method stub
		return repo.existsById(idProduto);
	}
	
	@Override
	public List<Produto> buscarPorPalavraChave(String palavra) {
		return repo.findAllByDetalhesContains(palavra);
	}
	

}
