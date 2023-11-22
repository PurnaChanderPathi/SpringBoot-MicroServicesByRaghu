package com.app.purna.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.dbcon.MyDbConnection;

@Component
public class TestDataRunner implements CommandLineRunner {
	@Autowired
	private MyDbConnection connection;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(connection);

	}

}
