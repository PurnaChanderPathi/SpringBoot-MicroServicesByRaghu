package com.app.purna.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Serializable> {

}
