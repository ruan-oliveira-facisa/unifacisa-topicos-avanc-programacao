package com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.entity.Cliente;
import com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.service.ClienteService;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//	   // Do any additional configuration here
//	   return builder.build();
//	}
	
	@GetMapping(value = "/teste")
	public ResponseEntity<String> consultarApi() {	
		
		 final String uri = "https://opcoes.net.br/";

		 RestTemplate restTemplate = new RestTemplate();
		 String result = restTemplate.getForObject(uri, String.class);
		
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@GetMapping(value = "/clientes")
	public ResponseEntity<List<Cliente>> listarClientes() {	
		List<Cliente> clientes = clienteService.listarTodosClientes();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
	@PostMapping(value = "/clientes")
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente novoCliente) {
		try {
			Cliente cliente = clienteService.cadastrarCliente(novoCliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/clientes/{sexo}")
	public ResponseEntity<List<Cliente>> listarClientesPorSexo(@PathVariable char sexo) {	
		List<Cliente> clientes = clienteService.listarClientePorSexo(sexo);
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

}	
	
//	@GetMapping(value = "/clientes")
//	//public ResponseEntity<List<Funcionario>> listarFuncionarios() {
//	public String listarFuncionarios() {	
//		//List<Funcionario> funcionarios = funcionarioService.listarTodosFuncionarios();
//		clienteService.listarTodosClientes();
//		//return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
//		return null;
//	}
	

