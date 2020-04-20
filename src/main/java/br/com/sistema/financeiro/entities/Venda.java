package br.com.sistema.financeiro.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.sistema.financeiro.domain.GenericDomain;

@Entity
public class Venda extends GenericDomain{
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionarioResponsavel;
	
	public Venda() {
	}

	public Venda(Date horario, BigDecimal valorTotal, Cliente cliente, Funcionario funcionarioResponsavel) {
		super();
		this.horario = horario;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}

	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	@Override
	public String toString() {
		return "Venda [horario=" + horario + ", valorTotal=" + valorTotal + ", cliente=" + cliente
				+ ", funcionarioResponsavel=" + funcionarioResponsavel + "]";
	}
	
	
	
}
