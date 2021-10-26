package com.havivis.controller;

import java.util.List;
import java.util.Optional;


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

import com.havivis.Service.FuncionarioService;
import com.havivis.model.Funcionario;
import com.havivis.model.FuncionarioLogin;
import com.havivis.repository.FuncionarioRepository;


@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService funcionarioService;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll(){
		
		return ResponseEntity.ok(funcionarioRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> findAllById(@PathVariable long id){
		
		return funcionarioRepository.findById(id)
				.map(x -> ResponseEntity.ok(x))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	@PutMapping
	public ResponseEntity<Funcionario> putFuncionario(@RequestBody Funcionario funcionario){
		
		return ResponseEntity.ok(funcionarioRepository.save(funcionario));
	}
	
	@DeleteMapping("/{id}")
	public void deletaFuncionario(@PathVariable long id) {
		funcionarioRepository.deleteById(id);
	}
	
	//====-==-=-=-=-==-=-=-=--==--==--=-=-=-=-=-=-=-=-=-=-=-=-=-=-NOVO USUARIO-=-=--==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=--=--=-==--=//
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Funcionario> postFuncionario(@RequestBody Funcionario funcionario){
		
		Optional<Funcionario> func = funcionarioService.cadastrarFuncionario(funcionario);
		
		try {
			return ResponseEntity.ok(func.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	//====-==-=-=-=-==-=-=-=--==--==--=-=-=-=-=-=-=-=-=-=-=-=-=-=-LOGAR USUARIO-=-=--==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=--=--=-==--=//
	
	
	@PostMapping("/logar")
	public ResponseEntity<FuncionarioLogin> autenticarLogin(@RequestBody Optional<FuncionarioLogin> funcLogin){
		
		return funcionarioService.logar(funcLogin).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
}
