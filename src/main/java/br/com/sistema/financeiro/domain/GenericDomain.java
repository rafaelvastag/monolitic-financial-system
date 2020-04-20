package br.com.sistema.financeiro.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Classe anotada por @MappedSuperclass que indica que tal classe não será uma tabela;
 * @author Rafael Vastag - 
 * @since 2020/04/17
 *
 */
@MappedSuperclass
public class GenericDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	public GenericDomain() {
	}
	
	public Long getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "GenericDomain [codigo=" + codigo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericDomain other = (GenericDomain) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}
