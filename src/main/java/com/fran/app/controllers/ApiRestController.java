package com.fran.app.controllers;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fran.app.controllers.entity.Actor;
import com.fran.app.controllers.entity.Pelicula;
import com.fran.app.controllers.entity.services.IActorService;
import com.fran.app.controllers.entity.services.IPeliculaService;
import com.fran.app.get.RestService;

@RestController
@RequestMapping("/api")
public class ApiRestController {

	// Atributos
	public static RestTemplateBuilder restTemplate = new RestTemplateBuilder();

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	private IPeliculaService peliculaService;

	@Autowired
	private IActorService actorService;

	// Metodos
	@GetMapping("/insert")
	public String insert() throws ParseException {

		// Llamamos al contexto del applicationContext donde tenemos el Bean
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Sacamos el Bean y llamamos a sus metodos correspondientes de insercion de
		// datos.
		RestService rest = context.getBean("obj", RestService.class);
		rest.setPeliculas(jdbc);
		rest.setActores(jdbc);
		context.close();

		return "Registros insertados, ya puedes volver atras a visualizarlo";
	}

	@GetMapping("/peliculas")
	public List<Pelicula> peliculas() {
		return peliculaService.todasPeliculas();
	}

	@GetMapping("/actores")
	public List<Actor> actores() {
		return actorService.todosActores();
	}

	@GetMapping("/peliculasordenadasvote")
	public List<Pelicula> peliculasOrdenadasVote() {
		return peliculaService.orderbyvote();
	}

	@GetMapping("/peliculasordenadasnombre")
	public List<Pelicula> peliculasOrdenadasNombre() {
		return peliculaService.orderbyname();
	}
	
	@GetMapping("/peliculas/{Id}")
	public Optional<Pelicula> findById(@PathVariable Long Id) {
		return peliculaService.getById(Id);
	}
	

}
