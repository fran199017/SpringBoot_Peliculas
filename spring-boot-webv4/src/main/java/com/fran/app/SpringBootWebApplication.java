/**
 * @author-> Francisco Nicolau Ausejo
 * @Description-> Este proyecto consiste en la extracción de datos de la API themoviedb, e inserción en una BBDD para luego poder listarlos.
Para ello utilizo JDBC desde application.properties y las anotaciones de Hibernate para las Entidades, desde donde se crean las tablas.
Es necesario crear una bbdd llamada dbpeliculas2.
 *
 */

package com.fran.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ComponentScan("com.fran.app")
@SpringBootApplication
@EntityScan
@EnableTransactionManagement
public class SpringBootWebApplication {
	
	public static RestTemplateBuilder restTemplate = new RestTemplateBuilder();

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);

	}


}
