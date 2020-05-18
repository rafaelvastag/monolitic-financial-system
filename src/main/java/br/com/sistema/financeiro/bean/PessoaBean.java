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
		pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
	}

	public void salvar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.salvar(pessoa);
			
			pessoas = pessoaDAO.findAll();
			
			pessoa = new Pessoa();
			
			pessoa.setEstado(new Estado());

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.findAll();

			cidades = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a pessoa");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

			PessoaDAO pessoaDAO = new PessoaDAO();

			pessoaDAO.excluir(pessoa);
			
			pessoas = pessoaDAO.findAll();

			Messages.addGlobalInfo("Estado removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o estado");
			erro.printStackTrace();
		}
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
