package com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.entity.Cliente;
import com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarTodosClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente cadastrarCliente(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarClientePorSexo(char sexo) {
		return this.clienteRepository.findBySexo(sexo);
	}

}





//public List<Cliente> listarTodosClientes() {
//System.out.println("OLA");
//return null;
//}

