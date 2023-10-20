package com.facisa.toavpr.aula.myApp.projeto07.tapProjeto07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api")
public class TutorialController {

	@Autowired
	TutorialRepository tutorialRepository;

	@GetMapping("/tutorials")
	public ResponseEntity<Map<String, Object>> getAllTutorials(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {

		try {
			List<Tutorial> tutorials = new ArrayList<Tutorial>();
			Pageable paging = PageRequest.of(page, size);

			Page<Tutorial> pageTuts;
			if (title == null)
				pageTuts = tutorialRepository.findAll(paging);
			else
				pageTuts = tutorialRepository.findByTitleContaining(title, paging);

			tutorials = pageTuts.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("tutorials", tutorials);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/tutorials-page")
	public Page<Tutorial> search(@RequestParam(required = false) String title,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		Pageable paging = PageRequest.of(page, size);
		
	
		return tutorialRepository.findAll(paging);

	}

	@GetMapping("/tutorials/published")
	public ResponseEntity<Map<String, Object>> findByPublished(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {
		try {
			List<Tutorial> tutorials = new ArrayList<Tutorial>();
			Pageable paging = PageRequest.of(page, size);

			Page<Tutorial> pageTuts = tutorialRepository.findByPublished(true, paging);
			tutorials = pageTuts.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("tutorials", tutorials);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
