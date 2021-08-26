package com.fran.app.controllers.entity.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fran.app.controllers.entity.Actor;
import com.fran.app.controllers.entity.dao.IActorDAO;




@Service
public class ActorServiceImpl implements IActorService {

	//Atributos
	@Autowired
	private IActorDAO actorDAO;
	
	//Metodos
	@Override	
	@Transactional  //Nos permite realizar la transaccion.
	public List<Actor> todosActores() {
		
		return (List<Actor>) actorDAO.findAll();
	}

}
