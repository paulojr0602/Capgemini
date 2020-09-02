package com.banco.capgemini.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.capgemini.entities.Cliente;
import com.banco.capgemini.entities.ContaCorrente;
import com.banco.capgemini.interfaces.repository.IClienteRepository;
import com.banco.capgemini.interfaces.repository.IContaCorrenteRepository;
import com.banco.capgemini.interfaces.service.IContaCorrenteService;

@Service
public class ContaCorrenteService implements IContaCorrenteService {
	

	@Autowired
	private  IContaCorrenteRepository contaRepository;
	@Autowired
	private IClienteRepository clienteRepository; 
	
	public ContaCorrenteService(IContaCorrenteRepository contaRepository, IClienteRepository clienteRepository) {
		super();
		this.contaRepository = contaRepository;
		this.clienteRepository = clienteRepository;
	}
		
	@Override
	public ContaCorrente CadastrarConta(ContaCorrente conta) {
		contaRepository.save(conta);
		return conta;
	}

	@Override
	public ContaCorrente AbrirConta(String cpf) {
		Cliente cliente = clienteRepository.findByCpf(cpf);
		if(cliente == null) {
			return null;			
		} else {
			ContaCorrente existeConta = ConsultarContaPorCpf(cpf);
			if(existeConta != null) {
				return existeConta;
			}
		}
					
		return contaRepository.save(GerarConta(cliente));
	}

	@Override
	public ContaCorrente GerarConta(Cliente cliente) {
		ContaCorrente contaNova = new ContaCorrente(cliente.getCpf(),cliente);
		return contaNova;
	}

	@Override
	public ContaCorrente ConsultarContaPorCpf(String cpf) {
		return contaRepository.findByCpf(cpf);
	}		
	
}
