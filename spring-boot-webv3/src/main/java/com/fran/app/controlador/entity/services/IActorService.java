package com.fran.app.controlador.entity.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fran.app.controlador.entity.Actor;

@Service
public interface IActorService {

	public List<Actor> todosActores();
	
}
