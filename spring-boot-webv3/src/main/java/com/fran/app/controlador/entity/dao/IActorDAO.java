package com.fran.app.controlador.entity.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fran.app.controlador.entity.Actor;



public interface IActorDAO extends JpaRepository<Actor, Long>{

	
}
