package com.fran.app.controlador.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fran.app.controlador.entity.Pelicula;

public interface IPeliculaDAO extends JpaRepository<Pelicula, Long>{

}
