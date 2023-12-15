package com.app.purna.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	 Optional<Customer> findByName(String name);

	Optional<Customer> deleteByName(String name);

}
