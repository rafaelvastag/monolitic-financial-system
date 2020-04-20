package br.com.sistema.financeiro.util;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil_backup {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuracao = new Configuration().configure();

			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();

			SessionFactory factory = configuracao.buildSessionFactory(registry);

			return factory;
		} catch (Throwable ex) {
			System.err.println("A conexão não foi criada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static EntityManager getEntityManager() {
		return sessionFactory.createEntityManager();
	}

}
