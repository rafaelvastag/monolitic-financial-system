package br.com.sistema.financeiro.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.sistema.financeiro.domain.GenericDomain;

@Entity
public class Cliente extends GenericDomain{
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	@Column(nullable = false)
	private Boolean liberado;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	public Cliente() {
	}

	public Cliente(Date dataCadastro, Boolean liberado, Pessoa pessoa) {
		super();
		this.dataCadastro = dataCadastro;
		this.liberado = liberado;
		this.pessoa = pessoa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Cliente [dataCadastro=" + dataCadastro + ", liberado=" + liberado + ", pessoa=" + pessoa + "]";
	}
	
	
}
