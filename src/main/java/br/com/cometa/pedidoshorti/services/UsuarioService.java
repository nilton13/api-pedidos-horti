package br.com.cometa.pedidoshorti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cometa.pedidoshorti.entities.Usuario;
import br.com.cometa.pedidoshorti.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		List<Usuario> list = repository.findAll();
		return list;
	}
	
	public Usuario create(Usuario obj) {
		return repository.save(obj);
	}
	
	public Usuario findById(Integer id) {
		Usuario obj = repository.findById(id).get();
		return obj;
	}
	
	public Usuario findByUsername(String username) {
		Usuario usuario = repository.findByUsername(username);
		return usuario;
	}
}
