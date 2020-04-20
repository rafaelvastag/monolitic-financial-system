package br.com.sistema.financeiro.testes;

import org.junit.Test;

import br.com.sistema.financeiro.util.HibernateUtil;

public class HibernateUtilTest {
	
	@Test
	public void testConexao() {
			HibernateUtil.init();;
	}

}
