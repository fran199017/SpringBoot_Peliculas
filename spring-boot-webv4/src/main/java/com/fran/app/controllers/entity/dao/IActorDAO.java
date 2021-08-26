package com.fran.app.controllers.entity.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fran.app.controllers.entity.Actor;



public interface IActorDAO extends JpaRepository<Actor, Long>{

	
}
