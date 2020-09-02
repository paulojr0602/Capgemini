package com.banco.capgemini.interfaces.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banco.capgemini.entities.HistoricoConta;

@Repository
public interface IHistoricoContaRepository extends JpaRepository<HistoricoConta, Long> {
	
	@Query(value = "SELECT * FROM Historico_Conta WHERE Id_ContaCorrente = ?1", nativeQuery = true)
	public List<HistoricoConta> ConsultarHistoricoPorIdConta(Long Id_ContaCorrente);
	
	@Query(value = "SELECT COALESCE(SUM(COALESCE(CASE WHEN tipo = 0 THEN valor ELSE (valor * -1) END, 0)), 0) SALDO FROM Historico_Conta WHERE Id_ContaCorrente = ?1", nativeQuery = true)
	public double ConsultarSaldoConta(Long Id_ContaCorrente);
	
}
