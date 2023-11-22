package com.app.purna.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.Model;

public interface ModelRepository 
	extends JpaRepository<Model, Integer> {

}
