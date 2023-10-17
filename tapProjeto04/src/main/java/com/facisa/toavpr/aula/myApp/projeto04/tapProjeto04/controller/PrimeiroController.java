package com.facisa.toavpr.aula.myApp.projeto04.tapProjeto04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import com.facisa.toavpr.aula.myApp.projeto04.tapProjeto04.entity.Projeto;

@RestController
@RequestMapping("/api")
public class PrimeiroController {
	
	@Autowired
	RestClient restClient;
	
	@GetMapping("/teste1")
	public ResponseEntity<String> getValor(){
		
		String result = restClient.get()
				  .uri("http://jsonplaceholder.typicode.com/posts")
				  .retrieve()
				  .body(String.class);
				System.out.println(result);
			
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@GetMapping("/teste2")
	public ResponseEntity<String> getValor2(){
		
		ResponseEntity<String> result = restClient.get()
				  .uri("http://jsonplaceholder.typicode.com/posts")
				  .retrieve()
				  .toEntity(String.class);
				System.out.println(result);
				System.out.println("Response status: " + result.getStatusCode());
				System.out.println("Response headers: " + result.getHeaders());
				System.out.println("Contents: " + result.getBody());
		
		
		return result;
	}
	
	@GetMapping("/teste3")
	public ResponseEntity<Projeto> getValor3(){

		int id = 1;
		Projeto projeto = restClient.get()
				  .uri("http://jsonplaceholder.typicode.com/posts/{id}", id)
				  //.accept(MediaType.APPLICATION_JSON)
				  .retrieve()
				  .body(Projeto.class);

		return new ResponseEntity<Projeto>(projeto,HttpStatus.OK);
	}
	
	@GetMapping("/teste4")
	public ResponseEntity<Projeto> getValor4(){

		Projeto projeto = new Projeto();
		projeto.setId(3);
		projeto.setUserId(3);
		projeto.setBody("Ola Todos");
		projeto.setTitle("Ola");
		
		ResponseEntity<Projeto> result =  restClient.post()
				  .uri("http://localhost:8080/api/funcionario2")
				  .contentType(MediaType.APPLICATION_JSON)
				  .body(projeto)
				  .retrieve()
				  .toEntity(Projeto.class);
		Projeto p = result.getBody();

		return new ResponseEntity<Projeto>(p, HttpStatus.OK);
	}
	
	@GetMapping("/teste5")
	public ResponseEntity<Projeto> getValor5(){
		int id = 1;
		Projeto projeto = new Projeto();
		projeto.setId(3);
		projeto.setUserId(3);
		projeto.setBody("Ola Todos");
		projeto.setTitle("Ola");
		
		ResponseEntity<Projeto> result =  restClient.put()
				  .uri("http://localhost:8080/api/funcionario3/{id}",id)
				  .contentType(MediaType.APPLICATION_JSON)
				  .body(projeto)
				  .retrieve()
				  .toEntity(Projeto.class);
		Projeto p = result.getBody();

		return new ResponseEntity<Projeto>(p, HttpStatus.OK);
	}
	
	@GetMapping("/teste6")
	public ResponseEntity<Projeto> getValor6(){
		int id = 10;
		ResponseEntity<Void> result =  restClient.delete()
				  .uri("http://localhost:8080/api/funcionario4/{id}",id)
				  .retrieve()
				  .toBodilessEntity();

		return new ResponseEntity<Projeto>(HttpStatus.OK);
	}
	
	

}
