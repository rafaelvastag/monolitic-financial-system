package br.com.sistema.financeiro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.sistema.financeiro.domain.GenericDomain;

/**
 *  Classe Estado - Entity que estente classe generica de @Id
 * @author 838146
 * @since 2020/04/17
 */

@Entity
public class Estado extends GenericDomain {
	
	@Column(length = 2, nullable = false)
	private String sigla;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	public Estado() {
	}

	public Estado(String sigla, String nome) {
		super();
		this.sigla = sigla;
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Estado [sigla=" + sigla + ", nome=" + nome + "]";
	}


}
