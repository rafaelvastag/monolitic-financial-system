package br.com.sistema.financeiro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.sistema.financeiro.domain.GenericDomain;

@Entity
public class Fornecedor extends GenericDomain{
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	public Fornecedor() {
	}

	public Fornecedor(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fornecedor [descricao=" + descricao + "]";
	}
	
	
}
