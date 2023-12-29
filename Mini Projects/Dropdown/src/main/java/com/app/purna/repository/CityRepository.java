package com.app.purna.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.City;

public interface CityRepository extends JpaRepository<City, Serializable> {

	List<City> findByStateId(Integer stateId);
}
