package com.banco.capgemini.services.classes;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banco.capgemini.entities.HistoricoConta;
import com.banco.capgemini.interfaces.repository.IHistoricoContaRepository;
import com.banco.capgemini.interfaces.service.IMovimentoContaService;

@Service
public class SacarContaCorrente implements IMovimentoContaService {
		
	@Autowired
	private IHistoricoContaRepository historicoRepository;
	
	public SacarContaCorrente(IHistoricoContaRepository historicoRepository) {
		this.historicoRepository = historicoRepository;
	}
	
	@Override
	public String MovimentarConta(HistoricoConta entidade) throws ValidationException {
					
		double saldoAtual = historicoRepository.ConsultarSaldoConta(entidade.getContaCorrente().getId());
		
		if (saldoAtual >= entidade.getValor()) {
			historicoRepository.save(entidade);				
		} else {
			throw new ValidationException("Saldo insuficiente para o valor solicitado.");				
		}	
		
		return String.valueOf(historicoRepository.ConsultarSaldoConta(entidade.getContaCorrente().getId()));
	}
}
