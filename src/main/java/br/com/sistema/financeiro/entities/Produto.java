package br.com.sistema.financeiro.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.sistema.financeiro.domain.GenericDomain;

@Entity
public class Produto extends GenericDomain {
	
	@Column(length = 80, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Fornecedor fornecedor;
	
	public Produto() {
	}

	public Produto(String descricao, int quantidade, BigDecimal preco, Fornecedor fornecedor) {
		super();
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fornecedor = fornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + ", quantidade=" + quantidade + ", preco=" + preco + ", fornecedor="
				+ fornecedor + "]";
	}
	
	
}
