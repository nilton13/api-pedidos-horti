package br.com.cometa.pedidoshorti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String codigo;
	private String embalagem;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy = "produto")
	private List<Pedido> pedidos = new ArrayList<>();

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer id, String nome, Fornecedor fornecedor, String codigo, String embalagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.fornecedor = fornecedor;
		this.codigo = codigo;
		this.embalagem = embalagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmbalagem() {
		return embalagem;
	}
	
	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, id, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(fornecedor, other.fornecedor) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

	
}
