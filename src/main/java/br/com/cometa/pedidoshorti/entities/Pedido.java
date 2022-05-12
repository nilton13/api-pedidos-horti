package br.com.cometa.pedidoshorti.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private Date data;
	private Double quantidade_total;
	private Double quantidade_pedida;
	private String dia_pedido;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "loja_id")
	private Loja loja;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(Integer id, Date data, Double quantidade_total, Double quantidade_pedida, String dia_pedido,
			Produto produto, Loja loja, Fornecedor fornecedor) {
		super();
		this.id = id;
		this.data = data;
		this.quantidade_total = quantidade_total;
		this.quantidade_pedida = quantidade_pedida;
		this.dia_pedido = dia_pedido;
		this.produto = produto;
		this.loja = loja;
		this.fornecedor = fornecedor;
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Loja getLoja() {
		return loja;
	}
	
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, dia_pedido, id, produto, quantidade_pedida, quantidade_total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(data, other.data) && Objects.equals(dia_pedido, other.dia_pedido)
				&& Objects.equals(id, other.id) && Objects.equals(produto, other.produto)
				&& Objects.equals(quantidade_pedida, other.quantidade_pedida)
				&& Objects.equals(quantidade_total, other.quantidade_total);
	}
	
	

}
