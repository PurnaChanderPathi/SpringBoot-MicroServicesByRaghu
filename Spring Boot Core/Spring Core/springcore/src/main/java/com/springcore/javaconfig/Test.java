package com.springcore.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		//to call xml file
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/javaconfig/config.xml");
		
		//to call configuration  class
		ApplicationContext context = new AnnotationConfigApplicationContext(javaConfig.class);
		Student student = context.getBean("getStudent",Student.class);
		System.out.println(student);
		student.study();

	}

}
