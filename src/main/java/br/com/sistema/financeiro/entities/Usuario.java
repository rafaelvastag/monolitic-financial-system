package br.com.sistema.financeiro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.sistema.financeiro.domain.GenericDomain;

@Entity
public class Usuario extends GenericDomain{
	
	@Column(length = 32,nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private Character tipo;
	
	@Column(nullable = false)
	private Boolean ativo;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	public Usuario() {
	}

	public Usuario(String senha, Character tipo, Boolean ativo, Pessoa pessoa) {
		super();
		this.senha = senha;
		this.tipo = tipo;
		this.ativo = ativo;
		this.pessoa = pessoa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Usuario [senha=" + senha + ", tipo=" + tipo + ", ativo=" + ativo + ", pessoa=" + pessoa + "]";
	}
	
	
}
