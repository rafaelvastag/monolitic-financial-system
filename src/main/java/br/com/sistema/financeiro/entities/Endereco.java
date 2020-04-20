package br.com.sistema.financeiro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.sistema.financeiro.domain.GenericDomain;

@Entity
public class Endereco extends GenericDomain{

	@Column(length = 100, nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private String numero;
	
	@Column(length = 10)
	private String complemento;
	
	@Column(length = 30, nullable = false)
	private String bairro;
	
	@Column(length = 10, nullable = false)
	private String cep;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidade cidade;
	
	public Endereco() {
	}

	public Endereco(String logradouro, String numero, String complemento, String bairro, String cep, Estado estado,
			Cidade cidade) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cep=" + cep + ", estado=" + estado + ", cidade=" + cidade + "]";
	}
	
	
}
