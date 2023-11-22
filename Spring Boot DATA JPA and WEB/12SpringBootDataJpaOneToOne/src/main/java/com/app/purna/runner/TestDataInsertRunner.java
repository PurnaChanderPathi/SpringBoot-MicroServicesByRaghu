package com.app.purna.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Role;
import com.app.purna.entity.User;
import com.app.purna.repo.RoleRepository;
import com.app.purna.repo.UserRepository;
@Component
public class TestDataInsertRunner implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Role r1 = new Role(503, "ADMIN");
		Role r2 = new Role(504, "GUEST");
		
		roleRepository.saveAll(Arrays.asList(r1,r2));
		
		User u1 = new User(10, "SYED", r1);
		User u2 = new User(11, "SAM", r2);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		

	}

}
