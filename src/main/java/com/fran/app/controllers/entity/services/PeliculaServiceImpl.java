package com.fran.app.controllers.entity.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fran.app.controllers.entity.Pelicula;
import com.fran.app.controllers.entity.dao.IPeliculaDAO;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	//Atributos
	@Autowired
	private IPeliculaDAO peliculaDAO;
	
	@Autowired
	JdbcTemplate jdbc = new JdbcTemplate();
	
	//Metodos	

	
	@Override
	 public List<Pelicula> listarPeliculas() {

	        String sql = "SELECT * FROM peliculas";

	        List<Pelicula> peliculas = new ArrayList<>();

	        List<Map<String, Object>> rows = jdbc.queryForList(sql);

	        for (Map row : rows) {
	            Pelicula obj = new Pelicula();
	            
	            obj.setId(((Long) row.get("id")));
	            obj.setNombre(((String) row.get("nombre")));
	            obj.setVote((Double) row.get("vote"));   
	            obj.setImage((String) row.get("image"));
	            
	          
	            peliculas.add(obj);
	     
	        }

	        return peliculas;
	    }
	
	@Override
	 public List<Pelicula> listarPeliculasPorNombre() {

	        String sql = "SELECT * FROM peliculas order by nombre asc";

	        List<Pelicula> peliculas = new ArrayList<>();

	        List<Map<String, Object>> rows = jdbc.queryForList(sql);

	        for (Map row : rows) {
	            Pelicula obj = new Pelicula();
	            
	            obj.setNombre(((String) row.get("nombre")));
	            obj.setVote((Double) row.get("vote"));
	          
	            peliculas.add(obj);
	     
	        }

	        return peliculas;
	    }

	
	@Override
	 public List<Pelicula> listarPeliculasPorVote() {

	        String sql = "SELECT * FROM peliculas order by vote desc";

	        List<Pelicula> peliculas = new ArrayList<>();

	        List<Map<String, Object>> rows = jdbc.queryForList(sql);

	        for (Map row : rows) {
	            Pelicula obj = new Pelicula();
	            
	            obj.setNombre(((String) row.get("nombre")));
	            obj.setVote((Double) row.get("vote"));
	          
	            peliculas.add(obj);
	     
	        }

	        return peliculas;
	    }
	
	@Override
	@Transactional
	public Optional<Pelicula> getById(Long Id) {
		return peliculaDAO.findById(Id);
	}


	
}
