package com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.entity.Usuario;
import com.facisa.toavpr.aula.myApp.projeto02.tapProjeto02.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public Usuario addUser(Usuario user) {
		return this.userRepository.save(user);
	}
	
	public Usuario listarUsuarioPorId(int id) {
		return this.userRepository.findById(id).get();
	}

}
