package com.banco.capgemini.services.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banco.capgemini.entities.HistoricoConta;
import com.banco.capgemini.interfaces.repository.IHistoricoContaRepository;
import com.banco.capgemini.interfaces.service.IMovimentoContaService;

@Service
public class DepositarContaCorrente implements IMovimentoContaService{

	@Autowired
	private IHistoricoContaRepository historicoRepository;
	
	public DepositarContaCorrente(IHistoricoContaRepository historicoRepository) {
		this.historicoRepository = historicoRepository;
	}
	
	@Override
	public String MovimentarConta(HistoricoConta entidade) {
		historicoRepository.save(entidade);
		
		return String.valueOf(historicoRepository.ConsultarSaldoConta(entidade.getContaCorrente().getId()));
	}

	
}
