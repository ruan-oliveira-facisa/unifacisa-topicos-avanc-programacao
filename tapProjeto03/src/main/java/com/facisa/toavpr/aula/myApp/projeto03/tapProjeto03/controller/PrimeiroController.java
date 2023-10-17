package com.facisa.toavpr.aula.myApp.projeto03.tapProjeto03.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.facisa.toavpr.aula.myApp.projeto03.tapProjeto03.entity.Projeto;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

@RestController
@RequestMapping("/api")
public class PrimeiroController {
	
	private static final Logger log = LoggerFactory.getLogger(PrimeiroController.class);
	private final static String USER_AGENT = "Mozilla/5.0";
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/teste1")
	public ResponseEntity<String> getValor(){
		
		String url = "http://jsonplaceholder.typicode.com/posts/1";
		RestTemplate client = new RestTemplate();
		String valor = client.getForObject(url, String.class);
        log.info("Resultado da Chamada REST: " + valor);
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	
	@GetMapping("/teste2")
	public ResponseEntity<Projeto> getValor2(){	
		String url = "http://jsonplaceholder.typicode.com/posts/1";
		RestTemplate client = new RestTemplate();
		Projeto valor = client.getForObject(url, Projeto.class);
        log.info("Resultado da Chamada REST: " + valor);
		return new ResponseEntity<Projeto>(valor,HttpStatus.OK);
	}
	
	@GetMapping("/teste3")
	public ResponseEntity<String> getValor3(){	
		String url = "https://opcoes.net.br/opcoes2/bovespa";
		RestTemplate client = new RestTemplate();		
		String valor = client.getForObject(url, String.class);
		return new ResponseEntity<String>(valor,HttpStatus.OK);
	}
	
	
	@GetMapping("/teste4")
	public ResponseEntity<String> getValor4() throws Exception{	
		String url = "https://opcoes.net.br/opcoes2/bovespa";
		RestTemplate client = new RestTemplate();
		
		String valor = client.getForObject(url, String.class);
		List<String> lista = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(valor, "\n");
		while ( st.hasMoreTokens() ) {
		    String linha = st.nextToken();
		    linha = linha.trim();
		    if(linha.contains("<option value=\"ML\" selected=\"selected\" data-load=\"false\" data-acoes=\"")) {
		    	String listaAcoes = linha
						.split("<option value=\"ML\" selected=\"selected\" data-load=\"false\" data-acoes=\"")[1]
								.split("\">Mais l&#xED;quidos</option>")[0];
				lista = Arrays.asList(listaAcoes.split(","));
		    }
		}
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	

	
		@GetMapping("/teste5")
		public ResponseEntity<String> getValor5() throws MalformedURLException, IOException {
		//String url = "https://www.gov.br/ebserh/pt-br/hospitais-universitarios/regiao-nordeste/huac-ufcg/acesso-a-informacao/boletim-de-servico/2023/boletim-de-servico-no-437-huac.pdf/@@download/file";
		String url = "https://www.africau.edu/images/default/sample.pdf";
		byte[] imageBytes = restTemplate.getForObject(url, byte[].class);
	   

			try {
				PdfReader pdfReader = new PdfReader(imageBytes);
				int pages = pdfReader.getNumberOfPages();
				System.out.println(url);
				for (int i = 1; i <= pages; i++) {
					String pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
					if (pageContent.contains("Continued")) {
						System.out.println("ACHOU");
						System.out.println(url);
					}
				}
				pdfReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<String>("", HttpStatus.OK);
		}
		
		@GetMapping("/teste6")
		public ResponseEntity<List<Projeto>> getValor6(){	
			String url = "http://jsonplaceholder.typicode.com/posts";
			RestTemplate client = new RestTemplate();		
			List<Projeto> projetos = client.getForObject(url, List.class);
			return new ResponseEntity<List<Projeto>>(projetos,HttpStatus.OK);
		}
		
		@GetMapping("/teste7")
		public ResponseEntity<List<Projeto>> getValor7(){	
			String url = "http://jsonplaceholder.typicode.com/posts";
			RestTemplate client = new RestTemplate();		
			ResponseEntity<List> response = client.getForEntity(url, List.class);
			List<Projeto> projetos = response.getBody();
			return new ResponseEntity<List<Projeto>>(projetos,HttpStatus.OK);
		}
		
		@GetMapping("/teste8")
		public ResponseEntity<List<Projeto>> getValor8(){	
			String url = "http://jsonplaceholder.typicode.com/posts";
			RestTemplate client = new RestTemplate();		
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.set("Autorization", "123465");
			headers.set("Teste", "Ola");
			HttpEntity<String> entity = new HttpEntity<String>(headers);			
			ResponseEntity<List> responseEntity = client.exchange(url, HttpMethod.GET, entity, List.class);		
			List<Projeto> projetos = responseEntity.getBody();
			return new ResponseEntity<List<Projeto>>(projetos,HttpStatus.OK);
		}
		
		
		@GetMapping("/teste9")
		public ResponseEntity<Projeto> getValor9(){	
			String url = "http://localhost:8080/api/funcionario2";
			RestTemplate client = new RestTemplate();		
			Projeto projeto = new Projeto();
			projeto.setId(3);
			projeto.setUserId(3);
			projeto.setBody("Ola Todos");
			projeto.setTitle("Ola");

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));		
			HttpEntity<Projeto> httpEntity = new HttpEntity<Projeto>(projeto, headers);
			
			
			client.postForEntity(url, httpEntity, Projeto.class);		
			return new ResponseEntity<Projeto>(projeto,HttpStatus.OK);
		}
		
		@GetMapping("/teste10")
		public ResponseEntity<Projeto> getValor10(){	
			String url = "http://localhost:8080/api/funcionario2";
			RestTemplate client = new RestTemplate();		
			
			Projeto projeto = new Projeto();
			projeto.setId(3);
			projeto.setUserId(3);
			projeto.setBody("Ola Todos");
			projeto.setTitle("Ola");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Projeto> httpEntity = new HttpEntity<Projeto>(projeto, headers);
			
			client.exchange(url,HttpMethod.POST, httpEntity, Projeto.class);		
			return new ResponseEntity<Projeto>(projeto,HttpStatus.OK);
		}
		
		@GetMapping("/teste11")
		public ResponseEntity<Projeto> getValor11(){	
			String url = "http://localhost:8080/api/funcionario3/1";
			RestTemplate client = new RestTemplate();		
			
			Projeto projeto = new Projeto();
			projeto.setId(3);
			projeto.setUserId(3);
			projeto.setBody("Ola Todos");
			projeto.setTitle("Ola");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Projeto> httpEntity = new HttpEntity<Projeto>(projeto, headers);
			
			client.put(url, projeto);
			return new ResponseEntity<Projeto>(projeto,HttpStatus.OK);
		}
		
		
		@GetMapping("/teste12")
		public ResponseEntity<Projeto> getValor12(){	
			String url = "http://localhost:8080/api/funcionario3/1";
			RestTemplate client = new RestTemplate();		
			
			Projeto projeto = new Projeto();
			projeto.setId(3);
			projeto.setUserId(3);
			projeto.setBody("Ola Todos");
			projeto.setTitle("Ola");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Projeto> httpEntity = new HttpEntity<Projeto>(projeto, headers);
			
			client.exchange(url,HttpMethod.PUT, httpEntity, Projeto.class);		
			return new ResponseEntity<Projeto>(projeto,HttpStatus.OK);
		}
		
		@GetMapping("/teste13")
		public ResponseEntity<Projeto> getValor13(){	
			String url = "http://localhost:8080/api/funcionario4/1";
			RestTemplate client = new RestTemplate();		

			client.delete(url);
			return new ResponseEntity<Projeto>(new Projeto(),HttpStatus.OK);
		}
		
		
		@GetMapping("/teste14")
		public ResponseEntity<Projeto> getValor14(){	
			String url = "http://localhost:8080/api/funcionario4/{id}";
			RestTemplate client = new RestTemplate();		
			Map<String, Integer> map = new HashMap<>();
			map.put("id", 1);
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<?> httpEntity = new HttpEntity<>(headers);
			client.exchange(url, HttpMethod.DELETE, httpEntity, Void.class, map); 
			
			return new ResponseEntity<Projeto>(new Projeto(),HttpStatus.OK);
		}
		
		
		
//		@GetMapping("/teste10")
//		public ResponseEntity<String> getValor10(){	
//			String url = "http://localhost/projeto";
//			RestTemplate client = new RestTemplate();		
//			String valor = client.getForObject(url, String.class);
//			return new ResponseEntity<String>(valor,HttpStatus.OK);
//		}
		
	
	

}
