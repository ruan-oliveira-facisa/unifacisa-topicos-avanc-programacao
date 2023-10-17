package com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.entity.Cliente;
import com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.entity.Usuario;
import com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.service.UserService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/api")
public class UserController {
	
	private static final String UPLOADED_FOLDER = "C:\\dev\\";
	
	@Autowired
	UserService userService;
	
	@PostMapping(path = "/user")
	public ResponseEntity<Usuario> addUser(@RequestBody Usuario userNovo) throws IOException {
		if (userNovo == null) {	
			return new ResponseEntity<>(userNovo, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			Usuario user = userService.addUser(userNovo);
			return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);	
		}
	}
	
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<Usuario> listarFuncionarios(@PathVariable int id) throws IOException {	
		Usuario usuario = userService.listarUsuarioPorId(id);
		Path path = Paths.get(UPLOADED_FOLDER + "arquivo.pdf");
        Files.write(path, usuario.getFoto());
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

}
