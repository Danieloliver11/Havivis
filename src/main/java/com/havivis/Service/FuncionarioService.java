package com.havivis.Service;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.apache.commons.codec.binary.Base64; 

import com.havivis.model.Funcionario;
import com.havivis.model.FuncionarioLogin;
import com.havivis.repository.FuncionarioRepository;

import java.nio.charset.Charset;

@Service
public class FuncionarioService {
	
	@Autowired
	public FuncionarioRepository funcionarioRepository;
	
	// verifica se já tem um funcionario no banco de dados se nao encripta sua senha e salva no banco
	public Optional<Funcionario> cadastrarFuncionario(Funcionario funcionario) {
		if(funcionarioRepository.findByuser(funcionario.getUser()).isPresent() && funcionario.getId() == 0) {
		
		return null;
		
		}
		
		BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder();
		
	
		String senhaEncriptada = encriptador.encode(funcionario.getSenha()) ;
		
		funcionario.setSenha(senhaEncriptada);
		
		
		return Optional.of(funcionarioRepository.save(funcionario));
		
	}

	public Optional<FuncionarioLogin> logar(Optional<FuncionarioLogin> funciLogin) {
		
		BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder();	
		
		Optional<Funcionario> funcionario = funcionarioRepository.findByuser(funciLogin.get().getUser()); // usuarioModel
		
		if(funcionario.isPresent()) {
			
			if(encriptador.matches(funciLogin.get().getSenha(), funcionario.get().getSenha())) {
				
				String auth = funciLogin.get().getUser() + ":" + funciLogin.get().getSenha();
				
				byte[] encriptoAuith = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				
				String authHeader = "Basic " + new String(encriptoAuith);
				
				funciLogin.get().setToken(authHeader);
				
				funciLogin.get().setId(funcionario.get().getId());;
				funciLogin.get().setNome(funcionario.get().getNome());
				funciLogin.get().setUser(funcionario.get().getUser());
				funciLogin.get().setEmail(funcionario.get().getEmail());
				funciLogin.get().setSenha(funcionario.get().getSenha());
				funciLogin.get().setTipo(funcionario.get().getTipo());
				
				return funciLogin;
			}
			
			
		}
		
		
		
		return Optional.empty();
	}
	
	
	
	
	
	
}
