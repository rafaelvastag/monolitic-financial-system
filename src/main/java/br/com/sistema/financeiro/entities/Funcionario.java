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
public class Funcionario extends GenericDomain {
	@Column(length = 15, nullable = false)
	private String carteiraTrabalho;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	public Funcionario() {
	}

	public Funcionario(String carteiraTrabalho, Date dataAdmissao, Pessoa pessoa) {
		super();
		this.carteiraTrabalho = carteiraTrabalho;
		this.dataAdmissao = dataAdmissao;
		this.pessoa = pessoa;
	}

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Funcionario [carteiraTrabalho=" + carteiraTrabalho + ", dataAdmissao=" + dataAdmissao + ", pessoa="
				+ pessoa + "]";
	}
	
	
}
