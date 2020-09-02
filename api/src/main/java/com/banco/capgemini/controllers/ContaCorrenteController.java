package com.banco.capgemini.controllers;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.banco.capgemini.entities.ContaCorrente;
import com.banco.capgemini.entities.HistoricoConta;
import com.banco.capgemini.interfaces.service.IContaCorrenteService;
import com.banco.capgemini.interfaces.service.IHistoricoContaService;
import com.banco.capgemini.interfaces.service.IMovimentoContaService;

@RestController
@RequestMapping("api")
public class ContaCorrenteController {

	private IContaCorrenteService contaCorrenteService;
	private IHistoricoContaService historicoContaService;
	private IMovimentoContaService movimentoContaService;
	
	public ContaCorrenteController(IContaCorrenteService contaCorrenteService, IHistoricoContaService historicoContaService,  IMovimentoContaService movimentoContaService) {
		super();
		this.contaCorrenteService = contaCorrenteService;
		this.historicoContaService = historicoContaService;
		this.movimentoContaService = movimentoContaService;
	}

	@PostMapping("/contacorrente")
	ContaCorrente post(@RequestParam(value = "cpf", defaultValue = "") String cpf) {
		return contaCorrenteService.AbrirConta(cpf);		
	}
	
	@GetMapping("/contacorrente")
	ContaCorrente get(@RequestParam(value = "cpf", defaultValue = "") String cpf) {
		return contaCorrenteService.ConsultarContaPorCpf(cpf);		
	}
	
	@GetMapping("/saldo")
	public double Saldo(@RequestParam(value = "id", defaultValue = "") Long id){
		return historicoContaService.ConsultarSaldoPoridConta(id);
	}
	
	@GetMapping("/extrato")
	public List<HistoricoConta> Extrato(@RequestParam(value = "id", defaultValue = "") Long id){
		return historicoContaService.ConsultarHistoricoPoridConta(id);
	}
	
	@PostMapping("/operacao")
	public String post(@RequestBody HistoricoConta entidade) {
		try {
			
			return String.valueOf(movimentoContaService.MovimentarConta(entidade));
			
		} catch (ValidationException e) {
			return e.getMessage();
		}		
	}

}
