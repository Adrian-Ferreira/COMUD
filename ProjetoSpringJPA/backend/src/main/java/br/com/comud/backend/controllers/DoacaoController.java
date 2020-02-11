package br.com.comud.backend.controllers;

import br.com.comud.backend.services.IDoarService;
import br.com.comud.backend.services.IProdutoService;

import br.com.comud.backend.models.Doacao;
import br.com.comud.backend.models.Produto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class DoacaoController {
    @Autowired
    private IDoarService servico;
    @Autowired
    private IProdutoService srv;

    @PostMapping("doar/create")
    public ResponseEntity<Doacao> create(@RequestBody Doacao doacao){  	
    	Produto p = srv.readById(doacao.getProduto().getIdProduto());
    	int id = p.getUsuario().getIdUsuario();
    	if(id == doacao.getUsuario().getIdUsuario()){	//verifica se produto pertence a usuario
            if(p.getStatus().startsWith("DISP")){		//verifica status do produto
                try {
                    p.setStatus("DOADO");
                    LocalDate localDate = LocalDate.now();
					doacao.setDataD(localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfMonth());
                    servico.create(doacao);
                    srv.update(p);
                    return ResponseEntity.ok(doacao);
                }
                catch(Exception ex) {
                    return ResponseEntity.badRequest().build();
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }
        
    @GetMapping("doar/read/{iddoacao}")
    public ResponseEntity<Doacao> readById(@PathVariable int iddoacao){
        Doacao doacao = servico.readById(iddoacao);
        if(doacao!=null) {
            return ResponseEntity.ok(doacao);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
