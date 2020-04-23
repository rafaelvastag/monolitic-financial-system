package br.com.sistema.financeiro.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.sistema.financeiro.entities.Cidade;
import br.com.sistema.financeiro.entities.Estado;
import br.com.sistema.financeiro.entities.Pessoa;

public class PessoaDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSalvar() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.findById(1L);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.findById(2L);
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.findById(1L);
		

		
		pessoaDAO.salvar(pessoa);
	}

}
