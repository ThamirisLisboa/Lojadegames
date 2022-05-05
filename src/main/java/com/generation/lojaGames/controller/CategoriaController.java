package com.generation.lojaGames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojaGames.Repository.categoriaRepository;


@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {
	
    @Autowired
	private categoriaRepository repository;
    
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
    	return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("{id}")
   public ResponseEntity<Categoria>  getById(@PathVariable Long id){
	  return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
			  .orElse(ResponseEntity.notFound().build());		  
   }
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Categoria>> getById(@PathVariable String titulo) {
    	return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }
    @PostMapping
    public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria){
    	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
    @PutMapping
    public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria) {
    	return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria)); 	
    }
    public void delete(@PathVariable Long id) {
    	repository.deleteById(id);
    }
}
