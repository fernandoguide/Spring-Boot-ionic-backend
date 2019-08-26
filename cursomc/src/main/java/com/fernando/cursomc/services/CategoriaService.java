package com.fernando.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.cursomc.domain.Categoria;
import com.fernando.cursomc.repositories.CategoriaRepository;
import com.fernando.cursomc.services.exepitions.ObjectNotFoundExecpition;



@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		 return obj.orElseThrow(() -> new ObjectNotFoundExecpition(
				 "Objeto nao encontrado! Id: " + id
				 + " Tipo: "+ Categoria.class.getName()));
		}
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
