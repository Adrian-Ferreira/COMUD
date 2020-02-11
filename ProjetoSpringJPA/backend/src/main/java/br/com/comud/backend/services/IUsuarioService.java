package br.com.comud.backend.services;

import java.util.List;

import br.com.comud.backend.models.Usuario;

public interface IUsuarioService {
	public void create(Usuario u);
	public Usuario readById (int idUsuario);
	public List<Usuario> readAll();
	public void update(Usuario u);
	public boolean existsById(int idUsuario);
	public Usuario autenticarUsuario(String email, String senha);
}
