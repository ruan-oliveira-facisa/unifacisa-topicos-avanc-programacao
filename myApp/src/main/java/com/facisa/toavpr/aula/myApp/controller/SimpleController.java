package com.facisa.toavpr.aula.myApp.controller;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.facisa.toavpr.aula.myApp.DTO.Pessoa;

@Controller
//@RestController
@RequestMapping("/api")
public class SimpleController {
//    @Value("${spring.application.name}")
//    String appName;

    @GetMapping("/title/{bookTitle}")
    public ResponseEntity<Pessoa> homePage(@PathVariable String bookTitle) throws ServerException {
       
    	Pessoa p = new Pessoa();
    	p.setNome(bookTitle);
    	
    	if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
        	 throw new ServerException("ERRO");
        }
  
    }
    
    @GetMapping("/teste")
    //@ResponseBody
    public String helloWord() {
    	return "Hello WOrd";
    }
    
//    @GetMapping("/title/{bookTitle}")
//    public List findByTitle(@PathVariable String bookTitle) {
//        return bookRepository.findByTitle(bookTitle);
//    }
    
    @GetMapping("/user")
    public ResponseEntity<List<Pessoa>> listarUser() {
    	
    	List<Pessoa> lista = new ArrayList<Pessoa>();
    	lista.add(new Pessoa("Ruan"));
    	lista.add(new Pessoa("Joao"));
    	lista.add(new Pessoa("Maria"));
    	return new ResponseEntity<List<Pessoa>>(lista,HttpStatus.OK);
    }
    
    
}