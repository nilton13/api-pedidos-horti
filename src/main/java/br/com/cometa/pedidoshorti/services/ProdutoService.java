package br.com.cometa.pedidoshorti.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cometa.pedidoshorti.entities.Fornecedor;
import br.com.cometa.pedidoshorti.entities.Produto;
import br.com.cometa.pedidoshorti.repositories.FornecedorRepository;
import br.com.cometa.pedidoshorti.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public List<Produto> findAll(){
		List<Produto> list = repository.findAll();
		return list;
	}
	
	public Produto create(Produto obj) {
		return repository.save(obj);
	}
	
	public Produto findById(Integer id) {
		Produto obj = repository.findById(id).get();
		return obj;
	}
	
	public List<Produto> findByFornecedor(Integer id){
		Fornecedor fornecedor = fornecedorRepository.findById(id).get();
		List<Produto> produtos = repository.findAll();
		List<Produto> produtosFornecedor = new ArrayList<>();
		
		for(Produto prod: produtos) {
			if(prod.getFornecedor() == fornecedor) {
				produtosFornecedor.add(prod);
			}
		}
		
		return produtosFornecedor;
		
	}
	
}
