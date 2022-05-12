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

import br.com.cometa.pedidoshorti.entities.Fornecedor;
import br.com.cometa.pedidoshorti.services.FornecedorService;

@RestController
@RequestMapping("/api/fornecedores")
@CrossOrigin("*")
public class FornecedorController {
	
	@Autowired
	private FornecedorService service;
	
	@PostMapping
	public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor obj){
		Fornecedor newObj = service.create(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll(){
		List<Fornecedor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Fornecedor> findById(@PathVariable Integer id){
		Fornecedor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
