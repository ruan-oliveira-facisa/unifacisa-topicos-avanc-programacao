package com.facisa.toavpr.aula.myApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/api/aula4")
public class QuartoController {

	@GetMapping("/language")
	public ResponseEntity<String> greeting(@RequestHeader(
			HttpHeaders.ACCEPT_LANGUAGE) String language) {
	    // code that uses the language variable
		System.out.println(language);
	    return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	
	@GetMapping("/custom")
	public ResponseEntity<String> doubleNumber(
			@RequestHeader("my-number") int myNumber) {
	    return new ResponseEntity<String>(String.format("%d * 2 = %d", 
	      myNumber, (myNumber * 2)), HttpStatus.OK);
	}
	
	
	@GetMapping("/listHeaders")
	public ResponseEntity<String> listAllHeaders(
	  @RequestHeader Map<String, String> headers) {
	    headers.forEach((key, value) -> {
	        System.out.println(String.format("Header '%s' = %s", key, value));
	    });

	    return new ResponseEntity<String>(
	      String.format("Listed %d headers", headers.size()), HttpStatus.OK);
	}
	
	@GetMapping("/getBaseUrl")
	public ResponseEntity<String> getBaseUrl(@RequestHeader HttpHeaders headers) {
	    InetSocketAddress host = headers.getHost();
	    String url = "http://" + host.getHostName() + ":" + host.getPort();
	    return new ResponseEntity<String>(String.format("Base URL = %s", url), HttpStatus.OK);
	}
	
	

}

