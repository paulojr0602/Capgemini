package com.banco.capgemini.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banco.capgemini.entities.Cliente;
import com.banco.capgemini.interfaces.repository.IClienteRepository;
import com.banco.capgemini.interfaces.service.IClienteService;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	private IClienteRepository repository;

	public ClienteService(IClienteRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Cliente CadastrarCliente(Cliente entidade) {
		Cliente cliente = repository.findByCpf(entidade.getCpf());
		if(cliente != null) {		
			return cliente;
		}		
		return repository.save(entidade);
	}

	@Override
	public Cliente ConsultarPorId(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Cliente findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

}
