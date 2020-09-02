package com.banco.capgemini.interfaces.service;

import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Component;

import com.banco.capgemini.entities.HistoricoConta;

@Component
public interface IMovimentoContaService {
	
	public String MovimentarConta(HistoricoConta historico) throws ValidationException;

}
