package br.com.cometa.pedidoshorti.dto;

import java.util.ArrayList;
import java.util.List;

public class PedidoAdmDTO {

	private String fornecedor;
	private String produto;
	private Double total;
	private List<QuantidadePeditoPorLojaDTO> quantidades = new ArrayList<>();
	
	public PedidoAdmDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PedidoAdmDTO(String fornecedor, String produto,Double total, List<QuantidadePeditoPorLojaDTO> quantidades) {
		super();
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.total = total;
		this.quantidades = quantidades;
	}

	public PedidoAdmDTO(String fornecedor, String produto, Double total) {
		super();
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.total = total;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
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
		//quantidades.add(new QuantidadePeditoPorLojaDTO( quantidade));
	}

	public void setLojas(Integer loja) {
		quantidades.add(new QuantidadePeditoPorLojaDTO(loja,0.0));
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total += total;
	}
	
}
