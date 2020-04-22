package br.com.sistema.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistema.financeiro.dao.FornecedorDAO;
import br.com.sistema.financeiro.dao.ProdutoDAO;
import br.com.sistema.financeiro.entities.Fornecedor;
import br.com.sistema.financeiro.entities.Produto;

@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Produto produto = new Produto();
	private List<Produto> produtos;
	private List<Fornecedor> fornecedor;

	public ProdutoBean() {
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "ProdutoBean [produto=" + produto + ", produtos=" + produtos + ", fornecedor=" + fornecedor + "]";
	}

	@PostConstruct
	public void listar() {

		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.findAll();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os produtos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			produto = new Produto();
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedor = fornecedorDAO.findAll();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar gerar um novo produto");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedor = fornecedorDAO.findAll();
			
		} catch (Exception erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um produto");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produto);
			novo();
			produtos = produtoDAO.findAll();
			Messages.addGlobalInfo("Produto salvo com sucesso");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar o produto");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);
			produtos = produtoDAO.findAll();
					
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar remover o produto");
			erro.printStackTrace();
		}
	}
}
