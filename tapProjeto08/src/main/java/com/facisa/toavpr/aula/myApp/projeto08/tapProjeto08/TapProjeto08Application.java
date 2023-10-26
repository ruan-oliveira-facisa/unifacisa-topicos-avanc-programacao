package com.facisa.toavpr.aula.myApp.projeto08.tapProjeto08;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TapProjeto08Application {

	public static void main(String[] args) {
		SpringApplication.run(TapProjeto08Application.class, args);
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
