package com.facisa.toavpr.aula.myApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facisa.toavpr.aula.myApp.DTO.User3;

@RestController
@RequestMapping("/api/aula6")
public class SextoController {
	
	@PutMapping("/teste1/{id}")
    public ResponseEntity<User3> updateUser(@PathVariable 
    		long id,@RequestBody User3 user) {
		User3 userUpdate = new User3();
//		User3 userDatabase = userRepository.findById(id)
//      .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));
		userUpdate.setId(id);
		
		userUpdate.setNome(user.getNome());
		userUpdate.setSobreNome(user.getSobreNome());
		userUpdate.setIdade(user.getIdade());

//        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(userUpdate);
    }

}
