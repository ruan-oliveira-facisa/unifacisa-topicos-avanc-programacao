package com.facisa.toavpr.aula.myApp.projeto06.tapProjeto06;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository repository;
  //@Tag(name = "Tutorial", description = "Tutorial management APIs")
    
    @Operation(summary = "Get book by id"
    )
    
    @ApiResponses({
        @ApiResponse(responseCode = "200", 
        		content = { @Content(schema = @Schema(implementation = Book.class), 
        		mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", 
        		description = "Recurso não encontrado", 
        		content = { @Content(schema = @Schema(implementation = Book.class)) }),
        @ApiResponse(responseCode = "500",
        		content = { @Content(schema = @Schema()) }) })
    
    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id) {
        return repository.findById(id).get();
            //.orElseThrow(() -> new BookNotFoundException());
    }

    @GetMapping("/")
    public Collection<Book> findBooks() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public Book updateBook(
      @PathVariable("id") final String id, @RequestBody final Book book) {
        return book;
    }
}