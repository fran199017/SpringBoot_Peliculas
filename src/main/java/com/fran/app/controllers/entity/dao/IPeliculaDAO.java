
package com.fran.app.controllers.entity.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.fran.app.controllers.entity.Pelicula;



public interface IPeliculaDAO extends PagingAndSortingRepository<Pelicula, Long>{
	
	
}