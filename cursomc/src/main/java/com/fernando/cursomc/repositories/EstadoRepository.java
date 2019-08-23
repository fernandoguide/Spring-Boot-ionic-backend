package com.fernando.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.cursomc.domain.Cidade;
import com.fernando.cursomc.domain.Estado;
import com.fernando.cursomc.domain.Produto;

@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Integer> {

}
