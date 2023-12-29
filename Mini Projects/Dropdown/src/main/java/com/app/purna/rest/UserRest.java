package com.app.purna.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.purna.entity.City;
import com.app.purna.entity.Country;
import com.app.purna.entity.State;
import com.app.purna.service.UserService;

@RestController
@CrossOrigin
public class UserRest {
	
	@Autowired
	private UserService service;
	
	/*
	 * public ResponseEntity<Map<Integer, String>> getCoun(){ Map<Integer, String>
	 * status = service.getCountries(); return new
	 * ResponseEntity<Map<Integer,String>>(HttpStatus.OK); }
	 */
	
	@GetMapping("/countries")
	public Map<Integer, String> getCountry(){
	  return service.getCountries();	 
	}
	
	@GetMapping("/state/{countryId}")
	public Map<Integer, String> findByCountryId( @PathVariable Integer countryId)
	{
		return service.findByCountryId(countryId);
	}
	
	@GetMapping("/city/{stateId}")
	public Map<Integer, String> findByStateId(@PathVariable Integer stateId)
	{
		return service.findByStateId(stateId);
	}
	
	@PostMapping("/countries")
	public Country saveCountry(@RequestBody Country country)
	{
		 Country saveCountry = service.saveCountry(country);
		return saveCountry;
	}
	
	@PostMapping("/state")
	public State saveState(@RequestBody State state)
	{
		State saveState = service.saveState(state);
		return saveState;
	}
	
	@PostMapping("/city")
	public City saveCity(@RequestBody City city)
	{
		City saveCity = service.saveCity(city);
		return saveCity;
	}
}
