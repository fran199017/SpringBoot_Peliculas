package com.fran.app.controlador.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.fran.app.controlador.entity.Pelicula;



public interface IPeliculaDAO extends PagingAndSortingRepository<Pelicula, Long>{
	
	
}
