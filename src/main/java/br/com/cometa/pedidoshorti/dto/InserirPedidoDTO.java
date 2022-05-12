package br.com.cometa.pedidoshorti.dto;

import java.io.Serializable;
import java.util.Date;

public class InserirPedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date data;
	private Double quantidade_total;
	private Double quantidade_pedida;
	private String dia_pedido;
	private Integer produto;
	private Integer loja;
	private Integer fornecedor;
	
	public InserirPedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InserirPedidoDTO(Integer id, Date data, Double quantidade_total, Double quantidade_pedida, String dia_pedido,
			Integer produto, Integer loja, Integer fornecedor) {
		super();
		this.id = id;
		this.data = data;
		this.quantidade_total = quantidade_total;
		this.quantidade_pedida = quantidade_pedida;
		this.dia_pedido = dia_pedido;
		this.produto = produto;
		this.loja = loja;
		this.setFornecedor(fornecedor);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getQuantidade_total() {
		return quantidade_total;
	}

	public void setQuantidade_total(Double quantidade_total) {
		this.quantidade_total = quantidade_total;
	}

	public Double getQuantidade_pedida() {
		return quantidade_pedida;
	}

	public void setQuantidade_pedida(Double quantidade_pedida) {
		this.quantidade_pedida = quantidade_pedida;
	}

	public String getDia_pedido() {
		return dia_pedido;
	}

	public void setDia_pedido(String dia_pedido) {
		this.dia_pedido = dia_pedido;
	}

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}

	public Integer getLoja() {
		return loja;
	}

	public void setLoja(Integer loja) {
		this.loja = loja;
	}

	public Integer getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Integer fornecedor) {
		this.fornecedor = fornecedor;
	}	

}
