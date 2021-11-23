package com.havivis.controller;

import java.util.List;

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

import com.havivis.model.Produto;
import com.havivis.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	
	
	///////////
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findAllById(@PathVariable long id){
		
		return produtoRepository.findById(id)
				.map(x -> ResponseEntity.ok(x))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Produto> postFuncionario(@RequestBody Produto produto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> putFuncionario(@RequestBody Produto produto){
		
		return ResponseEntity.ok(produtoRepository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deletaFuncionario(@PathVariable long id) {
		produtoRepository.deleteById(id); 
	}
}
