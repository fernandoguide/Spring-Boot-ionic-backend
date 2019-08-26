package com.fernando.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.cursomc.domain.Cliente;
import com.fernando.cursomc.repositories.ClienteRepository;
import com.fernando.cursomc.services.exepitions.ObjectNotFoundExecpition;



@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		
		 return obj.orElseThrow(() -> new ObjectNotFoundExecpition(
				 "Objeto nao encontrado! Id: " + id
				 + " Tipo: "+ Cliente.class.getName()));
		}

}
