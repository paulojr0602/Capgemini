package com.banco.capgemini.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banco.capgemini.entities.HistoricoConta;
import com.banco.capgemini.interfaces.repository.IHistoricoContaRepository;
import com.banco.capgemini.interfaces.service.IHistoricoContaService;

@Service
public class HistoricoContaService implements IHistoricoContaService {

	@Autowired
	private IHistoricoContaRepository historicoRepository;
	
	public HistoricoContaService(IHistoricoContaRepository historicoRepository) {
		super();
		this.historicoRepository = historicoRepository;
	}

	
	@Override
	public List<HistoricoConta> ConsultarHistoricoPoridConta(Long idConta) {	
		return historicoRepository.ConsultarHistoricoPorIdConta(idConta);
	}
		
	@Override
	public double ConsultarSaldoPoridConta(Long idConta) {
		return historicoRepository.ConsultarSaldoConta(idConta);
	}
	
}
