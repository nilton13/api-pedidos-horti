package br.com.cometa.pedidoshorti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cometa.pedidoshorti.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
