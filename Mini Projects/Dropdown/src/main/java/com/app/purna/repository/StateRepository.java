package com.app.purna.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.State;

public interface StateRepository extends JpaRepository<State, Serializable> {
	
	List<State> findByCountryId(Integer countryId);

}
