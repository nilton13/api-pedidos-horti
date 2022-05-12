package br.com.cometa.pedidoshorti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cometa.pedidoshorti.entities.Produto;
import br.com.cometa.pedidoshorti.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto obj){
		Produto newObj = service.create(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id){
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/fornecedor/{id}")
	public ResponseEntity<List<Produto>> findByFornecedor(@PathVariable Integer id){
		List<Produto> produtos = service.findByFornecedor(id);
		return ResponseEntity.ok().body(produtos);
	}
	
}
