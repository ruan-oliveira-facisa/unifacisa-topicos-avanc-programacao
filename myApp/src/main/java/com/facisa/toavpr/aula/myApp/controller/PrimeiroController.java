package com.facisa.toavpr.aula.myApp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facisa.toavpr.aula.myApp.teste.Delivery;
import com.facisa.toavpr.aula.myApp.teste.DeliveryDTO;

@RestController
@RequestMapping("/api/produtos")
public class PrimeiroController {
	
    @GetMapping("/teste")
	//@RequestMapping("teste")
    public String helloWord() {
    	Delivery delivery = new Delivery();
    	delivery.setCity("CG");
    	delivery.setCountry("Brasil");
    	ModelMapper modelMapper = new ModelMapper();
    	DeliveryDTO deliveryDTO = modelMapper.map(delivery, DeliveryDTO.class);
    	return "Hello Word";
    }
	
	@RequestMapping(value = "/teste2", method = RequestMethod.GET)
	public String helloWord2() {
    	return "Hello Word 2";
    }

	
	@RequestMapping(value = "/teste3", method = RequestMethod.GET)
	public String helloWord2(@RequestParam String nome, @RequestParam String sobrenome) {
    	return nome + sobrenome;
    }

}
