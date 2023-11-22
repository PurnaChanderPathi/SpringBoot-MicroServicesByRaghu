package com.app.purna.runner;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.entity.User;
import com.app.purna.repo.UserRepository;

@Component
public class UserTestRunner implements CommandLineRunner {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User uod = new User();
		uod.setUerid(10);
		uod.setUserName("AJAY");
		
		List<String> list = new LinkedList<>();
		list.add("ADMIN");
		list.add("MANAGER");
		
		uod.setRoles(list);
		
		repository.save(uod);
		

	}

}
