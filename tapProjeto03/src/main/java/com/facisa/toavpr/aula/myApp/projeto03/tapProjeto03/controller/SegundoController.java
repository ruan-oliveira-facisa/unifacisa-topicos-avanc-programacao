package com.facisa.toavpr.aula.myApp.projeto03.tapProjeto03.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.facisa.toavpr.aula.myApp.projeto03.tapProjeto03.entity.Projeto;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api2")
public class SegundoController {
	
	private static final Logger log = LoggerFactory.getLogger(SegundoController.class);
	private final static String USER_AGENT = "Mozilla/5.0";
	
	@Autowired
	WebClient createWebClient;
	
	@GetMapping("/teste1")
	public ResponseEntity<Mono<Projeto>> getValor1(){	
		
		String url = "http://jsonplaceholder.typicode.com/posts/1";
		Mono<Projeto> projeto = createWebClient.get()
				.uri(url)
				.retrieve()
				.bodyToMono(Projeto.class);
		System.out.println("");
		return new ResponseEntity(projeto, HttpStatus.OK);
		
	}
	
	@GetMapping("/teste2")
	public ResponseEntity<Mono<Projeto>> getValor2() throws URISyntaxException{		
		Projeto projeto = new Projeto();
		projeto.setId(3);
		projeto.setUserId(3);
		projeto.setBody("Ola Todos");
		projeto.setTitle("Ola");

		Mono<Projeto> response = createWebClient.post()
		    .uri(new URI("http://localhost:8080/api/funcionario2"))
		    .header("Authorization", "Bearer MY_SECRET_TOKEN")
		    .contentType(MediaType.APPLICATION_JSON)
		    .accept(MediaType.APPLICATION_JSON)
		    .body(BodyInserters.fromValue(projeto))
		    //.body(Mono.just(projeto), Projeto.class)
		    .retrieve()
		    .bodyToMono(Projeto.class);
		System.out.println("");
		return new ResponseEntity(response, HttpStatus.OK);
		
	}
	
	@GetMapping("/teste3")
	public ResponseEntity<Mono<Projeto>> getValor3() throws URISyntaxException{			
		Projeto projeto = new Projeto();
		projeto.setId(3);
		projeto.setUserId(3);
		projeto.setBody("Ola Todos");
		projeto.setTitle("Ola");

		Mono<Projeto> response = createWebClient.put()
			 .uri(uriBuilder -> uriBuilder
				   .path("/api/funcionario3/{id}")
				  .build(6))
		    .header("Authorization", "Bearer MY_SECRET_TOKEN")
		    .contentType(MediaType.APPLICATION_JSON)
		    .accept(MediaType.APPLICATION_JSON)
		    .body(BodyInserters.fromValue(projeto))
		    .retrieve()
		    .bodyToMono(Projeto.class);
		return new ResponseEntity(response, HttpStatus.OK);
		
	}
	
	@GetMapping("/teste4")
	public ResponseEntity<Mono<Projeto>> getValor4() throws URISyntaxException{	

		Projeto response = createWebClient.delete()
			 .uri(uriBuilder -> uriBuilder
				   .path("/api/funcionario4/{id}")
				  .build(6))
		    .retrieve()
		    .bodyToMono(Projeto.class).block();
		
		return new ResponseEntity(HttpStatus.OK);
		
	}
	
	
		
	
	

}
