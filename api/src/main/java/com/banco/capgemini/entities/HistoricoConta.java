package com.banco.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.banco.capgemini.enumerators.TipoMovimento;

/**
 * Classe de entidade de Historico de Conta Corrente
 * 
 * @author Paulo Roberto de Almeida Jr Data:29/08/2020
 * @version 1.0
 * @category entities
 */

@Entity
@Table(name="HistoricoConta")
public class HistoricoConta {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="tipo")
	private TipoMovimento tipoMovimento;
	
	private String data;
	
	private double valor;
	
	@ManyToOne
    @JoinColumn(name="idContacorrente", referencedColumnName = "id", nullable=false)
    private ContaCorrente contaCorrente;
	
	/*
	 * @ManyToOne(optional = false, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="idContacorrente", referencedColumnName = "id",
	 * nullable=false) private ContaCorrente contaCorrente;
	 */
	
	public HistoricoConta() {
		super();
	}
	
	public HistoricoConta(TipoMovimento eTipoMovimento, String data, ContaCorrente contaCorrente, double valor) {
		super();
		this.tipoMovimento = eTipoMovimento;
		this.data = data;
		this.contaCorrente = contaCorrente;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoMovimento geteTipoMovimento() {
		return tipoMovimento;
	}
	public void setTipoMovimento(TipoMovimento eTipoMovimento) {
		this.tipoMovimento = eTipoMovimento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

}