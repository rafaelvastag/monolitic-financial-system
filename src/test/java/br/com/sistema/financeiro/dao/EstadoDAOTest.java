package br.com.sistema.financeiro.dao;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.sistema.financeiro.entities.Estado;

public class EstadoDAOTest {

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
		Estado estado = new Estado();
		estado.setNome("Santa Catarina");
		estado.setSigla("SC");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);

	}

	@Test
	public void buscar() {

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.findById(2L);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	public void findAll() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultados = estadoDAO.findAll();

		for (Estado estado : resultados) {
			System.out.println(estado.getCodigo() + " - " + estado);
		}

	}

	@Test
	public void excluir() {
		Long codigo = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.findById(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	
	
	@Test
	public void editar(){
		Long codigo = 8L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.findById(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro editado - Antes:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
			
			estado.setNome("Santa Catarina");
			estado.setSigla("SC");
			estadoDAO.editar(estado);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}

}
