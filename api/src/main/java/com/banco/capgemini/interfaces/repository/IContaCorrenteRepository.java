package com.banco.capgemini.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.banco.capgemini.entities.ContaCorrente;

@Repository
public interface IContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
	
	@Query(value = "Select * From Conta_Corrente Inner Join Cliente ON Cliente.id = Cliente_id Where Cliente.cpf LIKE ?1", nativeQuery = true)
	public ContaCorrente findByCpf(String cpf);
}
