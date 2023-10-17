package com.facisa.toavpr.aula.myApp.projeto04.tapProjeto04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class TapProjeto04Application {

	public static void main(String[] args) {
		SpringApplication.run(TapProjeto04Application.class, args);
	}
	
	@Bean
	public RestClient createRestClient() {
		
		return RestClient.create();
	}

}
