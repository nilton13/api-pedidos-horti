package br.com.cometa.pedidoshorti.dto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRelatorioDTO {

	private String produto;
	private List<QuantidadePeditoPorLojaDTO> quantidades = new ArrayList<>();
	private Double total;
	
	public ProdutoRelatorioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoRelatorioDTO(String produto) {
		super();
		this.produto = produto;
	}

	public ProdutoRelatorioDTO(String produto, Double total) {
		super();
		this.produto = produto;
		this.total = total;
	}

	public ProdutoRelatorioDTO(String produto, List<QuantidadePeditoPorLojaDTO> quantidades, Double total) {
		super();
		this.produto = produto;
		this.quantidades = quantidades;
		this.total = total;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public List<QuantidadePeditoPorLojaDTO> getQuantidades() {
		return quantidades;
	}

	public void setQuantidades(Integer loja,Double quantidade) {
		quantidades.get(loja - 1).setQuantidade(quantidade);
	}
	
	public void criarQuantidades(Integer loja, Double quantidade) {
		quantidades.add(new QuantidadePeditoPorLojaDTO(loja, quantidade));
	}
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total += total;
	}
	
}
