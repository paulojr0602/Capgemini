package com.banco.capgemini.services;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.capgemini.entities.Cliente;
import com.banco.capgemini.entities.HistoricoConta;
import com.banco.capgemini.enumerators.TipoMovimento;
import com.banco.capgemini.interfaces.repository.IHistoricoContaRepository;
import com.banco.capgemini.interfaces.service.IClienteService;
import com.banco.capgemini.interfaces.service.IMovimentoContaService;
import com.banco.capgemini.services.classes.DepositarContaCorrente;
import com.banco.capgemini.services.classes.SacarContaCorrente;

@Service
public class MovimentoContaService implements IMovimentoContaService {
	
	@Autowired
	private IHistoricoContaRepository historicoRepository;
	private IClienteService clienteService;
			
	public MovimentoContaService(IHistoricoContaRepository historicoRepository, IClienteService clienteService) {
		super();
		this.historicoRepository = historicoRepository;
		this.clienteService = clienteService;
	}

	@Override
	public String MovimentarConta(HistoricoConta movimento) throws ValidationException {
		
		try {
			Cliente cliente = clienteService.findByCpf(movimento.getContaCorrente().getCliente().getCpf());
			if(cliente == null) {
				return "Cliente não encontrado.";
			}
		} catch (Exception e) {
			return "Cliente não encontrado.";
		}
		//Configura a ação para executar 
		if (movimento.geteTipoMovimento() == TipoMovimento.DEPOSITO) {
			DepositarContaCorrente depositar = new DepositarContaCorrente(historicoRepository);
			return String.valueOf(depositar.MovimentarConta(movimento));
		} else {
			SacarContaCorrente sacar = new SacarContaCorrente(historicoRepository);
			return String.valueOf(sacar.MovimentarConta(movimento));
		}		 
	}	
}
