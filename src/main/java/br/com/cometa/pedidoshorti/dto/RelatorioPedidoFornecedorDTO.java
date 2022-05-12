package br.com.cometa.pedidoshorti.dto;

import java.util.ArrayList;
import java.util.List;

public class RelatorioPedidoFornecedorDTO {

	private String fornecedor;
	private List<ProdutoRelatorioDTO> produtos = new ArrayList<>();
	
	public RelatorioPedidoFornecedorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RelatorioPedidoFornecedorDTO(String fornecedor, List<ProdutoRelatorioDTO> produtos) {
		super();
		this.fornecedor = fornecedor;
		this.produtos = produtos;
	}

	public RelatorioPedidoFornecedorDTO(String fornecedor) {
		super();
		this.fornecedor = fornecedor;
	}

	public String getFornecedor() {   
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<ProdutoRelatorioDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(ProdutoRelatorioDTO produto) {
		produtos.add(produto);
	}
	
	
}
