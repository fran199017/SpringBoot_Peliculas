package com.fran.app.controllers.entity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fran.app.controllers.entity.Pelicula;
import com.fran.app.controllers.entity.dao.IPeliculaDAO;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	//Atributos
	@Autowired
	private IPeliculaDAO peliculaDAO;
	
	//Metodos
	@Override	
	@Transactional  //Nos permite realizar la transaccion.
	public List<Pelicula> todasPeliculas() {
		
		return (List<Pelicula>) peliculaDAO.findAll();
	}

	@Override
	@Transactional
	public List<Pelicula> orderbyvote() {
		
		return (List<Pelicula>) peliculaDAO.findAll(Sort.by("vote").descending());
	}
	
	@Override
	@Transactional
	public List<Pelicula> orderbyname() {
		
		return (List<Pelicula>) peliculaDAO.findAll(Sort.by("nombre").ascending());
	}

	@Override
	@Transactional
	public Optional<Pelicula> getById(Long Id) {
		return peliculaDAO.findById(Id);
	}
	
	@Override
	public List<Pelicula> todasPeliculas2(String name) {
		return (List<Pelicula>) peliculaDAO.findAll();
	}
	



	

	
}
