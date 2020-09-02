package com.banco.capgemini.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.capgemini.entities.Cliente;
import com.banco.capgemini.entities.ContaCorrente;
import com.banco.capgemini.interfaces.repository.IClienteRepository;
import com.banco.capgemini.interfaces.repository.IContaCorrenteRepository;
import com.banco.capgemini.interfaces.repository.IHistoricoContaRepository;
import com.banco.capgemini.interfaces.service.IContaCorrenteService;

@Service
public class ContaCorrenteService implements IContaCorrenteService {
	

	@Autowired
	private  IContaCorrenteRepository contaRepository;
	@Autowired
	private IClienteRepository clienteRepository; 
	@Autowired
	private IHistoricoContaRepository historicoConta;
	
	public ContaCorrenteService(IContaCorrenteRepository contaRepository, IClienteRepository clienteRepository, IHistoricoContaRepository historicoConta) {
		super();
		this.contaRepository = contaRepository;
		this.clienteRepository = clienteRepository;
		this.historicoConta = historicoConta;
	}
		
	@Override
	public ContaCorrente CadastrarConta(ContaCorrente conta) {
		contaRepository.save(conta);
		return conta;
	}

	@Override
	public ContaCorrente AbrirConta(Long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		if(cliente == null) {
			return null;			
		} else {
			ContaCorrente existeConta = ConsultarContaPorIdCliente(id);
			if(existeConta != null) {
				return existeConta;
			}
		}
					
		return contaRepository.save(GerarConta(cliente));
	}

	@Override
	public ContaCorrente GerarConta(Cliente cliente) {
		Random gerador = new Random();
		ContaCorrente contaNova = new ContaCorrente(String.valueOf(gerador.nextInt(99999)),cliente);
		return contaNova;
	}

	@Override
	public ContaCorrente ConsultarContaPorCpf(String cpf) {
		ContaCorrente conta = contaRepository.findByCpf(cpf);
		if (conta != null) {
			conta.setSaldo(historicoConta.ConsultarSaldoConta(conta.getId()));			
		}else {
			return null;
		}
		return conta;
	}

	@Override
	public ContaCorrente ConsultarContaPorIdCliente(Long id) {
		ContaCorrente conta = contaRepository.findByIdCliente(id);
		if(conta != null) {
			conta.setSaldo(historicoConta.ConsultarSaldoConta(conta.getId()));			
		}else {
			return null;
		}
		
		return conta;
	}		
	
}
