package com.facisa.toavpr.aula.myApp.projeto08.tapProjeto08;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {


}
