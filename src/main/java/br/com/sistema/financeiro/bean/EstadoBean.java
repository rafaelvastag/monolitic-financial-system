package br.com.sistema.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistema.financeiro.dao.EstadoDAO;
import br.com.sistema.financeiro.entities.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private Estado estado = new Estado();
	private List<Estado> estados;

	public EstadoBean() {
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void novo() {
		this.estado = new Estado();
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public void salvar() {

		try {

			EstadoDAO estadoDAO = new EstadoDAO();
			
			if (estado.getNome()=="" || estado.getSigla() == "") {
				Messages.addGlobalInfo("Os campos devem estar preenchidos");
				return;
			}
			estadoDAO.salvar(estado);
			novo();
			estados = estadoDAO.findAll();
			Messages.addGlobalInfo("Estado salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado");
			erro.printStackTrace();
		}

	}

	@PostConstruct
	public void listar() {
		try {

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.findAll();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");

			EstadoDAO estadoDAO = new EstadoDAO();

			estadoDAO.excluir(estado);
			
			estados = estadoDAO.findAll();

			Messages.addGlobalInfo("Estado removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o estado");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
	}

}
