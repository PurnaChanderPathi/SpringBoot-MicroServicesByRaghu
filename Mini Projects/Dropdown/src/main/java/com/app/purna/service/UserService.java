package com.app.purna.service;

import java.util.Map;

import com.app.purna.entity.City;
import com.app.purna.entity.Country;
import com.app.purna.entity.State;

public interface UserService {
	
	public Map<Integer, String> getCountries();
	
	public Map<Integer, String> findByCountryId(Integer countryId);
	
	public Map<Integer, String> findByStateId(Integer stateId);
	
	public Country saveCountry(Country country);
	
	public State saveState(State state);
	
	public City saveCity(City city);


}
