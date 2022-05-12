package br.com.cometa.pedidoshorti.dto;

import java.io.Serializable;

public class QuantidadePeditoPorLojaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer loja;
	private Double quantidade;
	
	public QuantidadePeditoPorLojaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuantidadePeditoPorLojaDTO(Integer loja, Double quantidade) {
		super();
		this.loja = loja;
		this.quantidade = quantidade;
	}	

	public QuantidadePeditoPorLojaDTO(Integer loja) {
		super();
		this.loja = loja;
	}

	public Integer getLoja() {
		return loja;
	}

	public void setLoja(Integer loja) {
		this.loja = loja;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
