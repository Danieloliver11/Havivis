package com.havivis.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.havivis.model.Funcionario;
import com.havivis.repository.FuncionarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private FuncionarioRepository funcionarioRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Funcionario> funcionario = funcionarioRepo.findByuser(username);
		
		funcionario.orElseThrow(() -> new UsernameNotFoundException(username + "not found."));
		
		
		
		return funcionario.map(UserDetailsImplementation::new).get();
	}

}
