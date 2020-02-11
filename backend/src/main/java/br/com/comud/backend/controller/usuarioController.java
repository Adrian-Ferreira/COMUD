package br.com.comud.backend.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.comud.backend.model.usuario;
import br.com.comud.backend.security.autenticacao;
import br.com.comud.backend.security.token;

@RestController
@CrossOrigin("*")
public class usuarioController {
	ArrayList<usuario> lista = new ArrayList<usuario>();
	int id = 1;

	@PostMapping("/login")
	public ResponseEntity<token> autentica(@RequestBody usuario usuario) {
		for (int i = 0; i < lista.size(); i++) {
			if (usuario.getEmail().equals(lista.get(i).getEmail())
					&& usuario.getSenha().equals(lista.get(i).getSenha())) {
				usuario = lista.get(i);
				String tk = autenticacao.generateToken(usuario);
				token token = new token();
				token.setToken(tk);
				token.setNome(lista.get(i).getNome());
				token.setEmail(lista.get(i).getEmail());
				return ResponseEntity.ok(token);
			}
		}
		return ResponseEntity.status(403).build();
	}


	@PostMapping("/usuario/new")
	public ResponseEntity<usuario> newUser(@RequestBody usuario u) {
		if (lista.size() == 0) {
			u.setId(this.id++);
			lista.add(u);
			return ResponseEntity.ok(u);
		} else {
			for (usuario posicao : lista) {
				if (u.getEmail().equals(posicao.getEmail())) {
					return ResponseEntity.status(403).build();
				} else {
					u.setId(this.id++);
					lista.add(u);
					return ResponseEntity.ok(u);
				}
			}
		}
		return ResponseEntity.status(403).build();
	}

	@PutMapping("/usuario/atualiza")
	public ResponseEntity<usuario> alteraUsuario(@RequestBody usuario u) {
		int pos = -1;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == u.getId()) {
				pos = i;
				break;
			}
		}
		if (pos >= 0) {
			lista.set(pos, u);
			return ResponseEntity.ok(u);
		}
		return ResponseEntity.status(403).build();
	}

	@GetMapping("/usuario/todos")
	public ResponseEntity<ArrayList<usuario>> getTodos() {
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<usuario> getUsuario(@PathVariable int id) {

		usuario u = null;

		for (usuario user : lista) {
			if (user.getId() == id) {
				u = user;
				break;
			}
		}

		if (u != null) {
			return ResponseEntity.ok(u);
		} 
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
