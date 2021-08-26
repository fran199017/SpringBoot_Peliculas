package com.fran.app.get;


import java.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
	private  RestTemplate restTemplate;
	//Contador de paginas
	int contador=1;
	//Contador de actores
	int contadorActores=1;
	
	//Constructor
	public RestService() {
	
	}
	/**
	 * @param restTemplate2
	 */
	public RestService(RestTemplate restTemplate) {
		this.restTemplate = new RestTemplate();
	}

	//Metodos

	public String getPostsPlainJSON(String url) {		
		return this.restTemplate.getForObject(url, String.class);
	}
	
	
	//Registra las peliculas de la API
	public void setPeliculas(JdbcTemplate jdbc) {
	
				do {
					RestService rest= new RestService(restTemplate);		
					//Metemos el JSON en un String con el contador para contar el numero de paginas hasta llegar a 982
					String jsonString = rest.getPostsPlainJSON("https://api.themoviedb.org/3/movie/popular?api_key=8176f246492608b8378995922f26c645&language=en-US&page="+contador);
				
					//Lo convertimos a Object.
					JSONObject obj = new JSONObject(jsonString);

					//Cogemos lo que nos interesa de results(el titulo y la puntuación)
					JSONArray arr = obj.getJSONArray("results"); 
					for (int i = 0; i < arr.length(); i++)
					{
						
					    String original_title = arr.getJSONObject(i).getString("original_title");
					    double vote_average = arr.getJSONObject(i).getDouble("vote_average");
					    String overview= arr.getJSONObject(i).getString("overview");
					    
					    
					    System.out.println(original_title);
					    System.out.println(vote_average);
					    System.out.println(overview);
					    
					    //Controlo al tener el error, del caracter " ' " y entonces no insertar ese campo y tampoco mostrar el data inserted.
					    if(original_title.contains("'") ||overview.contains("'") ) {

					    	original_title= original_title.replace("'"," ");
					    	overview= overview.replace("'"," ");    	
					    	jdbc.execute("insert into peliculas(nombre,overview,vote)values('"+original_title+"',"+"'"+overview+"',"+"'"+vote_average+"')");
					    }else {
					    	jdbc.execute("insert into peliculas(nombre,overview,vote)values('"+original_title+"',"+"'"+overview+"',"+"'"+vote_average+"')");
				    	}
			    	    
					}//for
					
					//Incrementamos la pagina
					contador++;
					
				}while(contador<10);  //maximo de paginas de la api (He colocado 5 para no tardar tanto, son 982)
		
	}
	//Registra los actores de la API
	public void setActores(JdbcTemplate jdbc) {

		do {
			
			/*SOLUCION IMPROVISADA,PENDIENTE DE SOLUCIONAR
			Como hay registros de la API que no devuelven nada, salta un error, y se acaba el programa donde se haya quedado, 
			aunque si hace los registros, pero la idea es  que nos devuelva el mensaje de registros insertados.
			En estos numeros, no existen registros, así al menos podemos almacenar mas actores, no  solo los 14 primeros.
			Intentando aislar el HttPExcepcion para que cambie el contador.
			*/
			if(contadorActores==15) contadorActores=18;
			if(contadorActores==21) contadorActores++;
			if(contadorActores==25) contadorActores++;
//System.out.println(contadorActores);
			
			RestService rest= new RestService(restTemplate);		
			//Metemos el JSON en un String con el contador para contar el numero de actores hasta llegar a 100	
			String jsonString = rest.getPostsPlainJSON("https://api.themoviedb.org/3/person/"+contadorActores+"?api_key=8176f246492608b8378995922f26c645&language=en-US");
			
			//Lo convertimos a Object.
			JSONObject obj = new JSONObject(jsonString);


			
			 String nombre = obj.getString("name");
			 String nacimiento;
			 String lugarnacimiento;
			 
			
			  //Controlamos  nulos, ya que hay actores que no tienen fecha.
			 if (obj.has("birthday") && !obj.isNull("birthday")){
				 nacimiento = obj.getString("birthday");
			 } else {
				 nacimiento= "2000-01-01";
			 }
			 
			  LocalDate fechanacimiento= LocalDate.parse(nacimiento);
			 
			  
			//Controlamos  nulos, ya que hay actores que no tienen lugar de nacimiento.
			  if (obj.has("place_of_birth") && !obj.isNull("place_of_birth")){
				 lugarnacimiento = obj.getString("place_of_birth");
			 } else {
				 lugarnacimiento= "null";
			 }
			
			    System.out.println(nombre);
			    System.out.println(fechanacimiento);
			    System.out.println(lugarnacimiento);
			    
			    //Controlo al tener el error, del caracter " ' " y entonces no insertar ese campo y tampoco mostrar el data inserted.
			    if(nombre.contains("'") ||lugarnacimiento.contains("'") ) {

			    	nombre= nombre.replace("'"," ");
			    	lugarnacimiento= lugarnacimiento.replace("'"," ");    	
			    	jdbc.execute("insert into actores(nombre,nacimiento,lugarnacimiento)values('"+nombre+"',"+"'"+fechanacimiento+"',"+"'"+lugarnacimiento+"')");
			    }else {
			    	jdbc.execute("insert into actores(nombre,nacimiento,lugarnacimiento)values('"+nombre+"',"+"'"+fechanacimiento+"',"+"'"+lugarnacimiento+"')");
		    	}
			
			//Incrementamos la pagina
			contadorActores++;
			
			
			
		}while(contadorActores<40);  //maximo de paginas de la api (He colocado 5 para no tardar tanto, son 982)*/		
	}
	
}
