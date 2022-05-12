package br.com.cometa.pedidoshorti.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.cometa.pedidoshorti.entities.Pedido;

public class PedidoRenderDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String fornecedor;
	private String loja;
	private List<Pedido> pedidos = new ArrayList<>();
	
	public PedidoRenderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PedidoRenderDTO(String fornecedor, String loja, List<Pedido> pedidos) {
		super();
		this.fornecedor = fornecedor;
		this.loja = loja;
		this.pedidos = pedidos;
	}
	
	public PedidoRenderDTO(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	
}
