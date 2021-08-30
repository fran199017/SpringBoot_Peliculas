package com.fran.app.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fran.app.controllers.entity.Pelicula;
import com.fran.app.controllers.entity.services.PeliculaServiceImpl;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {

	
	@Autowired
	private PeliculaServiceImpl testPeliculaService;
	
	
	@Test
	public void contextLoads() {
		
		List<Pelicula> peliculas= testPeliculaService.listarPeliculas();
		
		
		//las peliculas deben estar vacias antes de ejecutarse la funcion de insertar
		Assert.assertEquals(peliculas.isEmpty(), true);
	}

}