package br.com.comud.backend.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.comud.backend.models.Produto;
import br.com.comud.backend.models.Troca;
import br.com.comud.backend.services.IProdutoService;
import br.com.comud.backend.services.ITrocaService;

@RestController
@CrossOrigin("*")
public class TrocaController {
	@Autowired
	private ITrocaService servico;
	@Autowired
	private IProdutoService srv;

	@PostMapping("trocar/create")
	public ResponseEntity<Troca> create(@RequestBody Troca troca) {
		Produto ced = srv.readById(troca.getCedido().getIdProduto());
		int idCed = ced.getUsuario().getIdUsuario();
		Produto rec = srv.readById(troca.getRecebido().getIdProduto());
		int idRec = rec.getUsuario().getIdUsuario();

		if (troca.getRemetente() != troca.getDestinatario() && troca.getCedido() != troca.getRecebido()) {				//verifica se usuarios e produtos são diferentes
			if (troca.getRemetente().getIdUsuario() == idRec && troca.getDestinatario().getIdUsuario() == idCed) { 		// verifica se produto pertence ao usuario
				if (ced.getStatus().startsWith("DISP") && rec.getStatus().startsWith("DISP")) { 						// verifica status do produto
					try {
						ced.setStatus("TROCADO");
						rec.setStatus("TROCADO");
						LocalDate localDate = LocalDate.now();
						troca.setDataT(localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfWeek().ordinal());
						servico.create(troca);
						srv.update(ced);
						srv.update(rec);
						return ResponseEntity.ok(troca);
					} catch (Exception ex) {
						return ResponseEntity.badRequest().build();
					}
				}
			}
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("trocar/read/{idTroca}")
	public ResponseEntity<Troca> readById(@PathVariable int idTroca) {
		Troca troca = servico.readById(idTroca);
		if (troca != null) {
			return ResponseEntity.ok(troca);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
