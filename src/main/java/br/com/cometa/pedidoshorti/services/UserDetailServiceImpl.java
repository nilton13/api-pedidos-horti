package br.com.cometa.pedidoshorti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cometa.pedidoshorti.entities.Usuario;
import br.com.cometa.pedidoshorti.repositories.UsuarioRepository;
import br.com.cometa.pedidoshorti.security.UserSS;


@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByUsername(username);
		if(usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new UserSS(usuario.getId(), usuario.getUsername(), usuario.getSenha());
	}

}

