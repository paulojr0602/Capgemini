package com.banco.capgemini.interfaces.service;

import com.banco.capgemini.entities.Cliente;
import com.banco.capgemini.entities.ContaCorrente;

public interface IContaCorrenteService {
	
	public ContaCorrente CadastrarConta(ContaCorrente conta);
	public ContaCorrente AbrirConta(String cpf);
	public ContaCorrente GerarConta(Cliente cliente);
	public ContaCorrente ConsultarContaPorCpf(String cpf);
	
}
