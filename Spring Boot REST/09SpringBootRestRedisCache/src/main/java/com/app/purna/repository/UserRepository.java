package com.app.purna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
