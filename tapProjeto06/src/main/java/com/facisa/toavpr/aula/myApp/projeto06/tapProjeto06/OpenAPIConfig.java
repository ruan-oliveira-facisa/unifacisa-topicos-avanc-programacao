package com.facisa.toavpr.aula.myApp.projeto06.tapProjeto06;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {
	
	@Bean
	  public OpenAPI myOpenAPI() {
	    Server devServer = new Server();
	    devServer.setUrl("http://localhost:8080");
	    devServer.setDescription("Server URL in Development environment");

	    Server prodServer = new Server();
	    prodServer.setUrl("https://bezkoder-api.com");
	    prodServer.setDescription("Server URL in Production environment");
	    
	    Contact contact = new Contact();
	    contact.setEmail("ruan.oliveira@gmail.com");
	    contact.setName("Ruan");
	    contact.setUrl("https://www.globo.com");

	    License mitLicense = new License().name("MIT License")
	    		.url("https://www.globo.com");

	    Info info = new Info()
	        .title("API REST RUAN")
	        .version("2.1")
	        .contact(contact)
	        .description("Esta API expõe endpoints para API de ruan.")
	        .termsOfService("https://www.globo.com")
	        .license(mitLicense);
	 return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	   
	}
}




	  
	  


