package com.fernando.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fernando.cursomc.domain.Categoria;
import com.fernando.cursomc.repositories.CategoriaRepository;
import com.fernando.cursomc.services.excepitions.DataIntegrityExecpition;
import com.fernando.cursomc.services.excepitions.ObjectNotFoundExecpition;



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
		return repo.saveAndFlush(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.saveAndFlush(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);	
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExecpition("Não é possivel exluir uma categoria que possiu produtos.");
		}		
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
}
