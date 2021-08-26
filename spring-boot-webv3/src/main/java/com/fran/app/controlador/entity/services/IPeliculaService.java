package com.fran.app.controlador.entity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.fran.app.controlador.entity.Pelicula;


@Service
public interface IPeliculaService {


	public List<Pelicula> todasPeliculas();
	public List<Pelicula> orderbyvote();
	public List<Pelicula> orderbyname();
	public List<Pelicula> todasPeliculas2(String name);
	public Optional<Pelicula> getById(Long id);

	
}
