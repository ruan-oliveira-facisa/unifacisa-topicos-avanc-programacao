package com.facisa.toavpr.aula.myApp.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.facisa.toavpr.aula.myApp.DTO.FormWrapper;
import com.facisa.toavpr.aula.myApp.DTO.Pessoa;
import com.facisa.toavpr.aula.myApp.DTO.User;
import com.facisa.toavpr.aula.myApp.DTO.User2;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/aula5")
public class QuintoController {
	
	private static final String UPLOADED_FOLDER = "C:\\dev\\";
	
	  @PostMapping("/teste")
	  public ResponseEntity<Pessoa> addPessoa(@RequestBody Pessoa p) {
		  if (p == null) {
			  return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		    } else {
		        return new ResponseEntity<>(p, HttpStatus.CREATED);
		    }
	  }
	  
	  
	  @RequestMapping(value = "/teste1", method = RequestMethod.POST)
	  public ResponseEntity<Pessoa> addPessoa1(@RequestBody Pessoa p) { 
	  
		  if (p == null) {
			  return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		    } else {
		        return new ResponseEntity<>(p, HttpStatus.CREATED);
		    }
	  }
	  
		@PostMapping(path = "/teste2", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
		public ResponseEntity<Pessoa> addPesso2(@RequestBody Pessoa p) {
			if (p == null) {
				return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<>(p, HttpStatus.CREATED);
			}
		}
		
		@PostMapping(path = "/teste3", consumes = { MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity<Pessoa> addPesso3(@RequestBody Pessoa p) {
			if (p == null) {
				return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<>(p, HttpStatus.CREATED);
			}
		}
		
		@PostMapping("/teste4")
	    public String postBody(@RequestBody String fullName) {
	        return "Hello " + fullName;
	    }
		
		@PostMapping("/teste5")
		public ResponseEntity<?> addPesso5(@ModelAttribute FormWrapper model) {
		    try {
		        // Save as you want as per requiremens
		        saveUploadedFile(model.getImage());
		        //formRepo.save(mode.getTitle(), model.getDescription());
		    } catch (IOException e) {
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }

		    return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
		}
		
		private void saveUploadedFile(MultipartFile file) throws IOException {
		    if (!file.isEmpty()) {
		        byte[] bytes = file.getBytes();
		        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		        Files.write(path, bytes);
		    }
		}
		
		
		@PostMapping(value = "/teste6", consumes = { MediaType.APPLICATION_JSON_VALUE, 
				MediaType.MULTIPART_FORM_DATA_VALUE})
		public ResponseEntity<?> addPesso6(@RequestPart("user") String user, 
				@RequestPart("file") List<MultipartFile> file) {

			User u;
			try {
				u = getJson(user, file);
			} catch (IOException e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity(u, HttpStatus.OK);
		}
		
		private User getJson(String user, List<MultipartFile> file) throws IOException {
			User userJson = new User();
			ObjectMapper objectMapper = new ObjectMapper();
			userJson = objectMapper.readValue(user, User.class);

			int fileCount = file.size();
			userJson.setContador(fileCount);
			return userJson;
		}
		
		
		@PostMapping(value = "/teste7",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
		        produces = {MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity<?> addPesso7(FormWrapper model) {
		    try {
		        // Save as you want as per requiremens
		        saveUploadedFile(model.getImage());
		        //formRepo.save(mode.getTitle(), model.getDescription());
		    } catch (IOException e) {
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }

		    return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
		}
		
		
		@PostMapping(path = "/teste8")
		public ResponseEntity<User2> addPesso8(@RequestBody User2 us2) throws IOException {
			if (us2 == null) {
				
				
				return new ResponseEntity<>(us2, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				Path path = Paths.get(UPLOADED_FOLDER + "arquivo.pdf");
		        Files.write(path, us2.getFoto());
				return new ResponseEntity<>(us2, HttpStatus.CREATED);
			}
		}
		
		@PostMapping(path = "/teste9")
		public ResponseEntity<?> addPesso9(@RequestParam("file") MultipartFile file, String isDuplex, int numberOfCopy, String printerName, String login) {
			try {
				return new ResponseEntity<>("Arquivo impresso com sucesso", HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<>("Ocorreu um erro na impresso do arquivo", HttpStatus.EXPECTATION_FAILED);
			}
		}



}
