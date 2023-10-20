package com.facisa.toavpr.aula.myApp.projeto05.tapProjeto05.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facisa.toavpr.aula.myApp.projeto05.tapProjeto05.entity.Projeto;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@Log4j2
public class PrimeiroController {

	
//	@GetMapping("/teste1")
//	public ResponseEntity<Projeto> getValor(){
//		Projeto projeto = Projeto.builder()
//		.userId(1)
//		.id(2)
//		.title("Titulo")
//		.body("Corpo")
//		.build();
//		return new ResponseEntity<Projeto>(
//				projeto,HttpStatus.OK);
//	}
	
	@GetMapping("/teste2")
	public ResponseEntity<Projeto> getValor2(){
		Projeto projeto = new Projeto();
		log.info("Controler 1 Info");
		if(log.isDebugEnabled()) {
			log.debug("Controler 1 Info");
		}
		
			
		return new ResponseEntity<Projeto>(
				projeto,HttpStatus.OK);
	}
	

	
	
		
	
	

}
