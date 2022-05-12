package br.com.cometa.pedidoshorti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cometa.pedidoshorti.entities.Loja;
import br.com.cometa.pedidoshorti.repositories.LojaRepository;

@Service
public class LojaService {

	@Autowired
	private LojaRepository repository;
	
	public List<Loja> findAll(){
		List<Loja> list = repository.findAll();
		return list;
	}
	
	public Loja create(Loja obj) {
		return repository.save(obj);
	}
	
	public Loja findById(Integer id) {
		Loja obj = repository.findById(id).get();
		return obj;
	}
	
	public Loja findByNumero(Integer numero) {
		Loja loja = repository.findByNumero(numero);
		return loja;
	}
	
	
	
}
