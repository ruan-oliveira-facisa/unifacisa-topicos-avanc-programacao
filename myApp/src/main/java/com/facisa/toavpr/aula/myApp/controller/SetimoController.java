package com.facisa.toavpr.aula.myApp.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facisa.toavpr.aula.myApp.DTO.User3;

@RestController
@RequestMapping("/api/aula7")
public class SetimoController {

	@DeleteMapping("/teste1/{id}")
	public ResponseEntity<User3> deleteUser(@PathVariable long id) {

		Optional<User3> user = Optional.of(new User3());
		// Optional<User3> user = _userRepository.findById(id);
		if (user.isPresent()) {
			// _userRepository.delete(user.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/teste2/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<User3> deleteUser2(@PathVariable long id) {

		Optional<User3> user = Optional.of(new User3());
		// Optional<User3> user = _userRepository.findById(id);
		if (user.isPresent()) {
			// _userRepository.delete(user.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
