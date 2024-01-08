package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.deo.StudentDeo;
import com.spring.jdbc.deo.StudentDeoImpl;

@Configuration
@ComponentScan(basePackages = "com.spring.jdbc.deo")
public class JdbcConfig {
	
	@Bean("ds")
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("Purnachander");
		ds.setPassword("Purna@123");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	// this code not used when we user annotation @Component @ComponentScan @AutoWired
//	@Bean("studentDeo")
//	public StudentDeo getStudentDeo()
//	{
//		StudentDeoImpl impl = new StudentDeoImpl();
//		impl.setJtm(getTemplate());
//		return impl;
//	}

}
