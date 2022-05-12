package br.com.cometa.pedidoshorti.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedidoExportacaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String loja;
	private List<PedidoRenderDTO> pedidos = new ArrayList<>();
	
	public PedidoExportacaoDTO() {
		
	}
	
	public PedidoExportacaoDTO(String loja, List<PedidoRenderDTO> pedidos) {
		super();
		this.loja = loja;
		this.pedidos = pedidos;
	}

	public PedidoExportacaoDTO(String loja) {
		super();
		this.loja = loja;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public List<PedidoRenderDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(PedidoRenderDTO pedido) {
		this.pedidos.add(pedido);
	}
	
	

}
