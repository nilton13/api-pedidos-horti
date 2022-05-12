package br.com.cometa.pedidoshorti.dto;

import java.io.Serializable;

public class InserirUsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String senha;
	private String funcao;
	private Integer loja;
	
	public InserirUsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InserirUsuarioDTO(Integer id, String nome, String senha, String funcao, Integer loja) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.funcao = funcao;
		this.loja = loja;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Integer getLoja() {
		return loja;
	}

	public void setLoja(Integer loja) {
		this.loja = loja;
	}
	
	

}
