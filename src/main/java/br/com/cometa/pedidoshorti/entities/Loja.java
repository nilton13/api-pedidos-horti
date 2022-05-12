package br.com.cometa.pedidoshorti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_loja")
public class Loja implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String nome;
	private Integer numero;
	
	@OneToMany(mappedBy = "loja")
	private List<Usuario> usuarios = new ArrayList<>();
	
	@OneToMany(mappedBy = "loja")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Loja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loja(Integer id, String nome, Integer numero) {
		super();
		this.id = id;
		this.nome = nome;
		this.numero = numero;
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	

}
