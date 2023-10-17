package com.facisa.toavpr.aula.myApp.projeto03.tapProjeto03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
//@EnableScheduling
public class TapProjeto03Application {

	public static void main(String[] args) {
		SpringApplication.run(TapProjeto03Application.class, args);
	}
	
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//	   // Do any additional configuration here
//	   return builder.build();
//	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public WebClient createWebClient() {
//		return WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com")
//				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//				.build();
		
		return WebClient.builder()
				.baseUrl("http://localhost:8080")
				.build();
	}
	
//	@Bean
//	public WebClient createRestClient() {
//		
//		return RestClient.create();
//	}

}
