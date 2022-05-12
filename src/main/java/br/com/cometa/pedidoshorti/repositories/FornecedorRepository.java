package br.com.cometa.pedidoshorti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cometa.pedidoshorti.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

}
