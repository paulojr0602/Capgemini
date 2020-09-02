package com.banco.capgemini.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.banco.capgemini.entities.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query(value = "Select * From Cliente Where cpf LIKE ?1", nativeQuery = true)
	public Cliente findByCpf(String cpf);
	
	@Query(value = "Select * From Cliente Where cpf LIKE ?1 AND senha LIKE ?2", nativeQuery = true)
	public String findByCpfSenha(String cpf, String senha);
}
