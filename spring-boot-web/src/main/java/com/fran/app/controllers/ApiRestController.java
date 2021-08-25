package com.fran.app.controllers;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fran.app.controlador.entity.Actor;
import com.fran.app.controlador.entity.Pelicula;
import com.fran.app.controlador.entity.services.IActorService;
import com.fran.app.controlador.entity.services.IPeliculaService;
import com.fran.app.get.RestService;

@RestController
@RequestMapping("/api")
public class ApiRestController {

	//Atributos
	public static RestTemplateBuilder restTemplate = new RestTemplateBuilder();
	
	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	private IPeliculaService peliculaService;

	@Autowired
	private IActorService actorService;
	
	@GetMapping("/peliculas")
	public List<Pelicula> peliculas(){
		return peliculaService.todasPeliculas();
	}
	
	@GetMapping("/actores")
	public List<Actor> actores(){
		return actorService.todosActores();
	}
	
	/*@GetMapping("/peliculasporaño")
	public List<Pelicula> peliculasporaño(){
		return peliculaService.orderbyaño();
	}*/
	
	@GetMapping("/insert")
	public String insert() throws ParseException {		
		
		//Llamamos al contexto del applicationContext donde tenemos el Bean
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Sacamos el Bean y llamamos a sus metodos correspondientes de insercion de datos.
		RestService rest= context.getBean("obj",RestService.class);	
		rest.setPeliculas(jdbc);
		rest.setActores(jdbc);	
		context.close();
		
		return"Registros insertados, ya puedes volver atras a visualizarlo";  
	}
	

}
