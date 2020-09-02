package com.banco.capgemini.services.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banco.capgemini.entities.HistoricoConta;
import com.banco.capgemini.entities.Operacao;
import com.banco.capgemini.interfaces.repository.IContaCorrenteRepository;
import com.banco.capgemini.interfaces.repository.IHistoricoContaRepository;
import com.banco.capgemini.interfaces.service.IMovimentoContaService;

@Service
public class DepositarContaCorrente implements IMovimentoContaService{

	@Autowired
	private IHistoricoContaRepository historicoRepository;
	@Autowired 
	private IContaCorrenteRepository contaCorrenteRepository;
	
	public DepositarContaCorrente(IHistoricoContaRepository historicoRepository, IContaCorrenteRepository contaCorrenteRepository) {
		this.historicoRepository = historicoRepository;
		this.contaCorrenteRepository = contaCorrenteRepository;
	}
	
	@Override
	public String MovimentarConta(Operacao movimento) {
		HistoricoConta historico = new HistoricoConta(movimento.getTipoMovimento(), movimento.getData(), contaCorrenteRepository.findById(movimento.getIdConta()).get(), movimento.getValor());
		
		historicoRepository.save(historico);
		
		return String.valueOf(historicoRepository.ConsultarSaldoConta(historico.getContaCorrente().getId()));
	}

	
}
