package com.fran.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fran.app.controllers.entity.Actor;
import com.fran.app.controllers.entity.Pelicula;
import com.fran.app.controllers.entity.services.IActorService;
import com.fran.app.controllers.entity.services.IPeliculaService;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Autowired
	private IPeliculaService peliculaService;
	
	@Autowired
	private IActorService actorService;

	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/pelis")
	public String pelis(Model modelo){
		
		List<Pelicula> peliculas= peliculaService.listarPeliculas();
		modelo.addAttribute("pelicula",peliculas);
		
		return "pelis";
	}
	
	@GetMapping("/pelisorderbyname")
	public String pelisorderbyname(Model modelo){
		
		List<Pelicula> peliculas= peliculaService.listarPeliculasPorNombre();
		modelo.addAttribute("pelicula",peliculas);
		
		return "pelisorderbyname";
	}
	
	@GetMapping("/pelisorderbyvote")
	public String pelisorderbyvote(Model modelo){
		
		List<Pelicula> peliculas= peliculaService.listarPeliculasPorVote();
		modelo.addAttribute("pelicula",peliculas);
		
		return "pelisorderbyvote";
	}
	
	@GetMapping("/actores")
	public String actores(Model modelo){
		
		List<Actor> actores= actorService.listarActores();
		modelo.addAttribute("actor",actores);
		
		return "actores";
	}
	

}
