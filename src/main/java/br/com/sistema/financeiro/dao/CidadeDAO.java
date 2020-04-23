package br.com.sistema.financeiro.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import br.com.sistema.financeiro.entities.Cidade;
import br.com.sistema.financeiro.entities.Estado;

public class CidadeDAO extends GenericDAO<Cidade>{


	@SuppressWarnings("unchecked")
	public List<Cidade> listByEstado(Estado estado) {

		  CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		    return entityManager.createQuery("from cidade where estado_codigo = " + estado.getCodigo()).getResultList();
		    
	}
}
