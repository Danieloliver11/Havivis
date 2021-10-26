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

import com.havivis.model.Pedido;
import com.havivis.repository.PedidorRepository;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {

	@Autowired
	public PedidorRepository pedidoRepository;
	
	
	
	///////////
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findAllById(@PathVariable long id){
		
		return pedidoRepository.findById(id)
				.map(x -> ResponseEntity.ok(x))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Pedido> postFuncionario(@RequestBody Pedido pedido){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
	}
	
	@PutMapping
	public ResponseEntity<Pedido> putFuncionario(@RequestBody Pedido pedido){
		
		return ResponseEntity.ok(pedidoRepository.save(pedido));
	}
	
	@DeleteMapping("/{id}")
	public void deletaFuncionario(@PathVariable long id) {
		pedidoRepository.deleteById(id); 
	}
}
