package com.facisa.toavpr.aula.myApp.projeto05.tapProjeto05.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.Accessors;

//@NonNull
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor 
//@NoArgsConstructor
//@RequiredArgsConstructor
//@Data

//@Builder
//@Value

//@Accessors(fluent = true)
//@Getter 
//@Setter 


//@Getter 
//@Setter 
@Data
public class Projeto {
	
	@Accessors(makeFinal = true)
	private int userId;
	private int id;
	private String title;
	private String body;
	
	
}
