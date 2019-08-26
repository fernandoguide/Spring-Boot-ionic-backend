package com.fernando.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.cursomc.domain.Pedido;
import com.fernando.cursomc.repositories.PedidoRepository;
import com.fernando.cursomc.services.exepitions.ObjectNotFoundExecpition;



@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		
		 return obj.orElseThrow(() -> new ObjectNotFoundExecpition(
				 "Objeto nao encontrado! Id: " + id
				 + " Tipo: "+ Pedido.class.getName()));
		}

}
