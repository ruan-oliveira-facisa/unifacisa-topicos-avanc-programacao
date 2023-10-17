package com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	public List<Cliente> findBySexo(char sexo);

}
