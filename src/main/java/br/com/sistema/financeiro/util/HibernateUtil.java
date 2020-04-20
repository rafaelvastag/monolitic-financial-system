package br.com.sistema.financeiro.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	public static EntityManagerFactory factory = null;

	static {
		init();
	}

	public static void init() {

		try {
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("Sistema-Financeiro");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method - getEntityManager()
	 * @return - EntityManager created by factory. It is used to do the persistence. 
	 */
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static EntityManagerFactory getSessionFactory() {
		return factory;
	}
	
	
	
	/**
	 * Method - getPrimaryKey
	 * @param entity
	 * @return Retorna a primary key.
	 */
	public static Object getPrimaryKey(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
}
