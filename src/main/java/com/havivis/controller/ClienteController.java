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

import com.havivis.model.Cliente;
import com.havivis.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	public ClienteRepository clienteRepository;
	
	
	
	///////////
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		
		return ResponseEntity.ok(clienteRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findAllById(@PathVariable long id){
		
		return clienteRepository.findById(id)
				.map(x -> ResponseEntity.ok(x))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> postFuncionario(@RequestBody Cliente cliente){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> putFuncionario(@RequestBody Cliente cliente){
		
		return ResponseEntity.ok(clienteRepository.save(cliente));
	}
	
	@DeleteMapping("/{id}")
	public void deletaFuncionario(@PathVariable long id) {
		clienteRepository.deleteById(id); 
	}

}
