package com.generation.lojaGames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojaGames.Repository.ProdutotosRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*")
public class ProdutosController {
     @Autowired
	private ProdutotosRepository repository;
	
     @GetMapping
	public ResponseEntity<List<Produtos>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
     @GetMapping("/{id}")
     public ResponseEntity<Produtos> getById(@PathVariable Long id) {
    	 return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
    			 .orElse(ResponseEntity.notFound().build());
     }
     @PostMapping
     public ResponseEntity<Categoria> post(@Valid @RequestBody Produtos produtos) {
    	 return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produtos));
     }
     @PutMapping
     public ResponseEntity<Produtos> put (@Valid @RequestBody Produtos produtos) {
    	 return ResponseEntity.status(HttpStatus.OK).body(repository.save(produtos));
     }
     @DeleteMapping
     public void delete(PathVariable Long id) {
    	 repository.deleteByid(id);
     }

}
