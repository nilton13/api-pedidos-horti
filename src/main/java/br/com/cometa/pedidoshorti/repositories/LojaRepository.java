package br.com.cometa.pedidoshorti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cometa.pedidoshorti.entities.Loja;

public interface LojaRepository extends JpaRepository<Loja, Integer> {

	@Transactional(readOnly = false)
	public Loja findByNumero(Integer numero);
}
