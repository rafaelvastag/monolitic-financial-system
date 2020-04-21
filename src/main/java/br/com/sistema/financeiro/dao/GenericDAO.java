package br.com.sistema.financeiro.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.sistema.financeiro.util.HibernateUtil;

/**
 * Recebe uma entidade, realizando as opera��es com o banco de dados;
 * 
 * @author 838146
 *
 * @param <Entity>
 */
abstract class GenericDAO<E> {

	private Class<E> classe;

	EntityManager entityManager = HibernateUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void salvar(E entidade) {

		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(entidade);
			transaction.commit();
		} catch (RuntimeException error) {
			if (transaction != null) {
				transaction.rollback();
			}
			error.printStackTrace();
			throw error;
		}
	}

	public List<E> findAll() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<E> resultSet = entityManager.createQuery("from " + classe.getName()).getResultList();
		transaction.commit();
		return resultSet;
	}

	public E findById(Long codigo) {

		try {
			E em = entityManager.find(classe, codigo);
			return em;

		} catch (RuntimeException e) {
			throw e;
		}
	}

	public void excluir(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(entidade) ? entidade : entityManager.merge(entidade));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				e.printStackTrace();
			}		
		}
	}

	public E editar(E entidade) {
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			E entidadeEditada = entityManager.merge(entidade);
			transaction.commit();
			return entidadeEditada;
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}e.printStackTrace();
			throw e;
		}
	}

}
