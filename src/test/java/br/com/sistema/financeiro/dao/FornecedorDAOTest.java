package br.com.sistema.financeiro.dao;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.sistema.financeiro.entities.Fornecedor;

public class FornecedorDAOTest {

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
	public void salvar() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setDescricao("Rafael Vastag Training");

		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.salvar(fornecedor);
	}

	@Test
	public void listar() {
		FornecedorDAO FornecedorDAO = new FornecedorDAO();
		List<Fornecedor> resultado = FornecedorDAO.findAll();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Fornecedor fornecedor : resultado) {
			System.out.println(fornecedor.getCodigo() + " - " + fornecedor.getDescricao());
		}
	}
	
	@Test
	public void buscar(){
		Long codigo = 3L;
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDAO.findById(codigo);
		
		if(fornecedor == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado:");
			System.out.println(fornecedor.getCodigo() + " - " + fornecedor.getDescricao());
		}
	}
	
	@Test
	public void testDelete() {
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDAO.findById(13L);
		
		fornecedorDAO.excluir(fornecedor);
		
	}

}
