package com.banco.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe de entidade de ContaCorrente
 * 
 * @author Paulo Roberto de Almeida Jr. Data:29/08/2020
 * @version 1.0
 * @category entities
 */
@Entity
@Table(name="ContaCorrente")
public class ContaCorrente {
	
	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private String numero;
	private double Saldo;
	
	@OneToOne
	private Cliente cliente;
				
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
/*
	public Set<HistoricoConta> getHistoricoConta() {
		return historicoConta;
	}

	public void setHistoricoConta(Set<HistoricoConta> historicoConta) {
		this.historicoConta = historicoConta;
	}*/

	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(double saldo) {
		Saldo = saldo;
	}

}