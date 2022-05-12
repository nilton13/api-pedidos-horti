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

import br.com.cometa.pedidoshorti.entities.Loja;
import br.com.cometa.pedidoshorti.services.LojaService;

@RestController
@RequestMapping("/api/lojas")
@CrossOrigin("*")
public class LojaController {
	
	@Autowired
	private LojaService service;
	
	@PostMapping
	public ResponseEntity<Loja> create(@RequestBody Loja obj){
		Loja newObj = service.create(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@GetMapping
	public ResponseEntity<List<Loja>> findAll(){
		List<Loja> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Loja> findById(@PathVariable Integer id){
		Loja obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
