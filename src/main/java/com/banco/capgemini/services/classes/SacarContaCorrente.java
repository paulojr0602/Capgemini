package com.banco.capgemini.services.classes;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banco.capgemini.entities.HistoricoConta;
import com.banco.capgemini.entities.Operacao;
import com.banco.capgemini.interfaces.repository.IContaCorrenteRepository;
import com.banco.capgemini.interfaces.repository.IHistoricoContaRepository;
import com.banco.capgemini.interfaces.service.IMovimentoContaService;

@Service
public class SacarContaCorrente implements IMovimentoContaService {
		
	@Autowired
	private IHistoricoContaRepository historicoRepository;
	@Autowired 
	private IContaCorrenteRepository contaCorrenteRepository;
	public SacarContaCorrente(IHistoricoContaRepository historicoRepository, IContaCorrenteRepository contaCorrenteRepository) {
		this.historicoRepository = historicoRepository;
		this.contaCorrenteRepository = contaCorrenteRepository;
	}
	
	@Override
	public String MovimentarConta(Operacao movimento) throws ValidationException {
		HistoricoConta historico = new HistoricoConta(movimento.getTipoMovimento(), movimento.getData(), contaCorrenteRepository.findById(movimento.getIdConta()).get(), movimento.getValor());
		double saldoAtual = historicoRepository.ConsultarSaldoConta(historico.getContaCorrente().getId());
		
		if (saldoAtual >= historico.getValor()) {
			historicoRepository.save(historico);				
		} else {
			throw new ValidationException("Saldo insuficiente para o valor solicitado.");				
		}	
		
		return String.valueOf(historicoRepository.ConsultarSaldoConta(historico.getContaCorrente().getId()));
	}
}
