package com.facisa.toavpr.aula.myApp.projeto07.tapProjeto07;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	Page<Tutorial> findByPublished(boolean published, Pageable pageable);

	Page<Tutorial> findByTitleContaining(String title, Pageable pageable);

}
