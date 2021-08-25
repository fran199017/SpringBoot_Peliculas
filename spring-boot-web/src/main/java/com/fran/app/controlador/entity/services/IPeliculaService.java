package com.fran.app.controlador.entity.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fran.app.controlador.entity.Pelicula;

@Service
public interface IPeliculaService {

	public List<Pelicula> todasPeliculas();
	
	//public List<Pelicula> orderbyaño();
	
}
