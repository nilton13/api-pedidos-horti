package br.com.cometa.pedidoshorti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cometa.pedidoshorti.entities.Fornecedor;
import br.com.cometa.pedidoshorti.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	public List<Fornecedor> findAll(){
		List<Fornecedor> list = repository.findAll();
		return list;
	}
	
	public Fornecedor create(Fornecedor obj) {
		return repository.save(obj);
	}
	
	public Fornecedor findById(Integer id) {
		Fornecedor obj = repository.findById(id).get();
		return obj;
	}
	
}
