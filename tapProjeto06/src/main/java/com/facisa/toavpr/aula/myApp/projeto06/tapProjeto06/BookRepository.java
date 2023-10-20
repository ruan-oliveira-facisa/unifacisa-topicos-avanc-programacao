package com.facisa.toavpr.aula.myApp.projeto06.tapProjeto06;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	

}
