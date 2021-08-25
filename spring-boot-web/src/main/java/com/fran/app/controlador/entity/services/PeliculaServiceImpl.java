package com.fran.app.controlador.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fran.app.controlador.entity.Pelicula;
import com.fran.app.controlador.entity.dao.IPeliculaDAO;

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

	/*@Override
	@Transactional  //Nos permite realizar la transaccion.
	public List<Pelicula> orderbyaño() {
		
		return (List<Pelicula>) peliculaDAO.findAll(Sort.by(Sort.Direction.DESC,"vote_average"));
	}*/
	

}
