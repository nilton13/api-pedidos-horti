package br.com.cometa.pedidoshorti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cometa.pedidoshorti.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsername(String username);
}
