package com.fran.app.get;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RestService {
	private final RestTemplate restTemplate;
	private String url;

	
	//Constructor
	public RestService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	//Metodos

	public String getPostsPlainJSON(String url) {		
		this.url=url;
		return this.restTemplate.getForObject(url, String.class);
	}
	

}
