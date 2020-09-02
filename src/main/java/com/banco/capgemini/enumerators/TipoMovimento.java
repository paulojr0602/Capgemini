package com.banco.capgemini.enumerators;

public enum TipoMovimento {

	DEPOSITO(0L, "Deposito"),
	SAQUE(1L, "Saque");
	
	private Long valor;
	private String descricao;
	
	private TipoMovimento(Long valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}