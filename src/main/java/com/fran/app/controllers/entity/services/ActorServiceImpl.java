package com.fran.app.controllers.entity.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fran.app.controllers.entity.Actor;
import com.fran.app.controllers.entity.dao.IActorDAO;


@Service
public class ActorServiceImpl implements IActorService {

	//Atributos
	
	@Autowired
	JdbcTemplate jdbc = new JdbcTemplate();

	
	//Metodos
	@Override
	 public List<Actor> listarActores() {

	        String sql = "SELECT * FROM actores";

	        List<Actor> actores = new ArrayList<>();

	        List<Map<String, Object>> rows = jdbc.queryForList(sql);

	        for (Map row : rows) {
	            Actor obj = new Actor();
	            
	            obj.setId(((Long) row.get("id")));
	            obj.setNombre(((String) row.get("nombre")));
	            obj.setLugarNacimiento(((String) row.get("lugarnacimiento")));
	         
	            actores.add(obj);
	     
	        }

	        return actores;
	    }
	

}
