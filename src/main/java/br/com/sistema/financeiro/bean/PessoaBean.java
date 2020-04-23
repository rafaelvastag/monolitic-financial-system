package br.com.sistema.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistema.financeiro.dao.CidadeDAO;
import br.com.sistema.financeiro.dao.EstadoDAO;
import br.com.sistema.financeiro.dao.PessoaDAO;
import br.com.sistema.financeiro.entities.Cidade;
import br.com.sistema.financeiro.entities.Estado;
import br.com.sistema.financeiro.entities.Pessoa;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas;
	private List<Estado> estados;
	private List<Cidade> cidades;

	public PessoaBean() {
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	public String toString() {
		return "PessoaBean [pessoa=" + pessoa + ", pessoas=" + pessoas + ", estados=" + estados + ", cidades=" + cidades
				+ "]";
	}

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.findAll();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as pessoas");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

	}

	public void salvar() {

	}

	public void excluir(ActionEvent evento) {

	}

	public void novo() {

		try {
			pessoa = new Pessoa();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.findAll();
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.findAll();

		} catch (Exception erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo produto");
			erro.printStackTrace();
		}

	}

	public void popular() {
		try {
			if (pessoa.getEstado() != null) {
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.listByEstado(pessoa.getEstado());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar filtrar as cidades");
			erro.printStackTrace();
		}
	}

}
