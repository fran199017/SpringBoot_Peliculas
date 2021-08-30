package com.fran.app.controllers.entity.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fran.app.controllers.entity.Actor;

@Service
public interface IActorService {	
	
	//Metodos
	public List<Actor> listarActores();	
}
