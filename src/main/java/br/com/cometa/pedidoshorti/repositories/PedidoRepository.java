package br.com.cometa.pedidoshorti.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cometa.pedidoshorti.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	@Transactional(readOnly = false)
	public List<Pedido> findByData(Date data); 
}
