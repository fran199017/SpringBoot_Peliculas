package com.fran.app.controllers.entity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fran.app.controllers.entity.Pelicula;


@Service
public interface IPeliculaService {


	public List<Pelicula> listarPeliculas(Integer pageNo, Integer pageSize, String sortBy);
	public List<Pelicula> listarPeliculasPorNombre();
	public List<Pelicula> listarPeliculasPorVote();
	
	public Optional<Pelicula> getById(Long id);





	

	
}
