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

import br.com.comud.backend.model.produto;

@RestController
@CrossOrigin("*")
public class produtoController {
	
	ArrayList<produto> lista = new ArrayList<produto>();
	int id=1;
	
	
	@PostMapping("/produto/new")
	public ResponseEntity<produto> newProd(@RequestBody produto p){
		p.setId(this.id++);
		lista.add(p);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping("/produto/todos")
	public ResponseEntity<ArrayList<produto>> getTodos(){
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<produto> getProduto(@PathVariable int id){
	
		produto p = null;
		
		for (produto prod: lista) {
			if (prod.getId() == id) {
				p = prod;
				break;
			}
		}
			
			if (p != null) {  
				return ResponseEntity.ok(p);
			}
			else {
				return ResponseEntity.notFound().build();
			}		
		}
	
	@PutMapping("/produto/atualiza")
	public ResponseEntity<produto> alteraProduto(@RequestBody produto p){
		int pos = -1;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == p.getId()) {
				pos = i;
				break;
			} 
		}
		if (pos >= 0) {
			lista.set(pos, p);
			return ResponseEntity.ok(p);
		}
		return ResponseEntity.status(403).build();
	}
		
	}
	
