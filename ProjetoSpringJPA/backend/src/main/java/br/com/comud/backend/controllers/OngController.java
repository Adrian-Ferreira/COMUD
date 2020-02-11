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
import org.springframework.web.bind.annotation.RestController;

import br.com.comud.backend.models.Ong;
import br.com.comud.backend.services.IOngService;

@RestController
@CrossOrigin("*")
public class OngController {
	@Autowired
	private IOngService servico;
	
	@PostMapping("ong/create")
	public ResponseEntity<Ong> create(@RequestBody Ong ong){
		try {
			servico.create(ong);
			return ResponseEntity.ok(ong);
		}
		catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("ong/read/{idONG}")
	public ResponseEntity<Ong> readById(@PathVariable int idONG){
		Ong ong = servico.readById(idONG);
		if(ong!=null) {
			return ResponseEntity.ok(ong);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("ong/update")
	public ResponseEntity<Ong> update(@RequestBody Ong ong){
		if(servico.existsById(ong.getIdONG())) {
			try {
			servico.update(ong);
			return ResponseEntity.ok(ong);
			}
			catch(Exception ex) {
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/ong/todos")
	public ResponseEntity<List<Ong>> readAll(){
		return ResponseEntity.ok(servico.readAll());
	}
}
