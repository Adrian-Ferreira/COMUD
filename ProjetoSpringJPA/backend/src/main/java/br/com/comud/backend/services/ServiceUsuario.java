package br.com.comud.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.comud.backend.daos.IUsuarioDB;
import br.com.comud.backend.models.Usuario;

@Component
public class ServiceUsuario implements IUsuarioService{

	@Autowired
	IUsuarioDB repo;
	
	@Override
	public void create(Usuario u) {
		// TODO Auto-generated method stub
		repo.save(u);
	}

	@Override
	public Usuario readById(int idUsuario) {
		// TODO Auto-generated method stub
			return repo.findById(idUsuario).get();
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>)repo.findAll();
	}
	
	@Override
	public void update(Usuario u) {
		// TODO Auto-generated method stub
		repo.save(u);
	}

	@Override
	public boolean existsById(int idUsuario) {
		// TODO Auto-generated method stub
		return repo.existsById(idUsuario);
	}

	@Override
	public Usuario autenticarUsuario(String email, String senha) {
		// TODO Auto-generated method stub
		return repo.findByEmailAndSenha(email, senha);
	}
	

}
