package com.app.purna.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.purna.entity.City;
import com.app.purna.entity.Country;
import com.app.purna.entity.State;
import com.app.purna.repository.CityRepository;
import com.app.purna.repository.CountryRepository;
import com.app.purna.repository.StateRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;

	public Map<Integer, String> getCountries() {
		
		List<Country> countries = countryRepository.findAll();
		
		Map<Integer, String> countryMap = new HashMap<>();
		
		countries.forEach(action -> {
			countryMap.put(action.getCountryId(), action.getCountryName());
		});
		
		
		return countryMap;
	}

	@Override
	public Map<Integer, String> findByCountryId(Integer countryId) {
	  List<State> state = stateRepository.findByCountryId(countryId);
		
		Map<Integer, String> stateMap = new HashMap<>();
		state.forEach(action -> {
			stateMap.put(action.getStateId(), action.getStateName());
		});

		return stateMap;
	}

	@Override
	public Map<Integer, String> findByStateId(Integer stateId) {
		List<City> city = cityRepository.findByStateId(stateId);
		Map<Integer, String> cityMap = new HashMap<>();
		city.forEach( action -> {
			cityMap.put(action.getCityId(), action.getCityName());
		});
		return cityMap;
	}

	@Override
	public Country saveCountry(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public State saveState(State state) {
		return stateRepository.save(state);
	}

	@Override
	public City saveCity(City city) {
		return cityRepository.save(city);
	}


}
