package com.app.purna.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.app.purna.entity.User;
import com.app.purna.repository.UserRepository;


@Service
public class UserService {
	
    @Autowired
	private UserRepository repo;
    
    public Integer saveUser(User user) {
      return repo.save(user).getId();
    }
    

	@Cacheable(value = "Student", key = "#userId")
	public User getOneUser(Integer userId) {
		return repo.findById(userId).get();
	}
    
	
	@CachePut(value = "Student", key = "#userId")
	public void updateUser(Integer userId, User user) {
		User userDb = repo.findById(userId).get();
		userDb.setName(user.getName());
		userDb.setRole(user.getRole());
		repo.save(userDb);
	}
    
    @CacheEvict(value = "Student", allEntries = true)
    public void deleteUser(Integer userId) {
		repo.deleteById(userId);
	}

}
