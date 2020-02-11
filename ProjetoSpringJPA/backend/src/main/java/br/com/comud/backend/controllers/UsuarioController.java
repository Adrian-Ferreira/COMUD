package br.com.comud.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.comud.backend.models.Usuario;
import br.com.comud.backend.security.autenticacao;
import br.com.comud.backend.security.token;
import br.com.comud.backend.services.IUsuarioService;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	@Autowired
	private IUsuarioService servico;
	
	@PostMapping("/usuario/login")
    public ResponseEntity<token> loginUsuario(@RequestBody Usuario usuario){
    	Usuario u = servico.autenticarUsuario(usuario.getEmail(), usuario.getSenha());
    	if (u != null) {
    		token token = autenticacao.generateToken(u);
    		return ResponseEntity.ok(token);
    	}
    	else {
    		return ResponseEntity.status(403).build();
    	}
    }
	
	@PostMapping("usuario/create")
	public ResponseEntity<Usuario> create(@RequestBody Usuario u){
		try {
			servico.create(u);
			return ResponseEntity.ok(u);
		}
		catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("usuario/read/{idUsuario}")
	public ResponseEntity<Usuario> readById(@PathVariable int idUsuario){
		Usuario u = servico.readById(idUsuario);
		if(u!=null) {
			return ResponseEntity.ok(u);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/usuario/todos")
	public ResponseEntity<List<Usuario>> readAll(){
		return ResponseEntity.ok(servico.readAll());
	}
	
	@PutMapping("usuario/update")        
	public ResponseEntity<Usuario> update(@RequestBody Usuario u){
		if(servico.existsById(u.getIdUsuario())) {
			try {
			servico.update(u);
			return ResponseEntity.ok(u);
			}
			catch(Exception ex) {
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.badRequest().build();	
	}
	@GetMapping("/userinfo")
	public ResponseEntity<Usuario> getInfo(@RequestParam String token) {
		if (token != null) {
			if (autenticacao.isValid(token)) {
				Usuario tmp = autenticacao.extractUser(token);
				System.out.println(tmp);
				return ResponseEntity.ok(autenticacao.extractUser(token));
			}
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/detalhes")
	public ResponseEntity<Usuario> detalhesUsuario(@RequestParam String token){
		
		//primeiro passo estrair id através do token
		Usuario user = autenticacao.extractUser(token);
		
		user = servico.readById(user.getIdUsuario());
				
		//retornar detalhes do usuario
		return ResponseEntity.ok(user);
		
		
	}
}
