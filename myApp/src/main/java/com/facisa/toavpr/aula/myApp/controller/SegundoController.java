package com.facisa.toavpr.aula.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ruan")
public class SegundoController {
	
  @GetMapping("/teste")
  public String findByTitle() {
      return "OLa";
  }

}
