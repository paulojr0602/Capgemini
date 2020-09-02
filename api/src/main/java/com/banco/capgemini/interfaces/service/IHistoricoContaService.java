package com.banco.capgemini.interfaces.service;

import java.util.List;

import org.springframework.stereotype.Component;
import com.banco.capgemini.entities.HistoricoConta;

@Component
public interface IHistoricoContaService {
	
	public List<HistoricoConta> ConsultarHistoricoPoridConta(Long idConta);
	public double ConsultarSaldoPoridConta(Long idConta);
}
