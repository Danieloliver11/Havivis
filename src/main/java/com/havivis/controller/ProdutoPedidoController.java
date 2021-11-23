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

import com.havivis.model.ProdutoPedido;
import com.havivis.repository.ProdutoPedidoRepository;

@RestController
@RequestMapping("/produtoPedido")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoPedidoController {

	@Autowired
	public ProdutoPedidoRepository repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoPedido> findAllById(@PathVariable long id){
		
		return repository.findById(id)
				.map(x -> ResponseEntity.ok(x))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping
	public ResponseEntity<List<ProdutoPedido>> findAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<ProdutoPedido> postFuncionario(@RequestBody ProdutoPedido produtoPedido){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produtoPedido));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoPedido> putFuncionario(@RequestBody ProdutoPedido produtoPedido){
		
		return ResponseEntity.ok(repository.save(produtoPedido));
	}
	
	@DeleteMapping("/{id}")
	public void deletaFuncionario(@PathVariable long id) {
		repository.deleteById(id); 
	}
}
