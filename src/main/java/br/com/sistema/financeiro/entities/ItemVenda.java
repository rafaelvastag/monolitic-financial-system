package br.com.sistema.financeiro.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.sistema.financeiro.domain.GenericDomain;

@Entity
public class ItemVenda extends GenericDomain{
	
	@Column(nullable = false)
	private Short quantidade;
	
	@Column(nullable = false)
	private BigDecimal valorParcial;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Venda venda;
	
	public ItemVenda() {
	}

	public ItemVenda(Short quantidade, BigDecimal valorParcial, Produto produto, Venda venda) {
		super();
		this.quantidade = quantidade;
		this.valorParcial = valorParcial;
		this.produto = produto;
		this.venda = venda;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public String toString() {
		return "ItemVenda [quantidade=" + quantidade + ", valorParcial=" + valorParcial + ", produto=" + produto
				+ ", venda=" + venda + "]";
	}

	
}
