package com.springcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ci/ciconfig.xml");
			Person person= context.getBean("person",Person.class);
			System.out.println(person); 
			
			Addition addition= context.getBean("add",Addition.class);
			addition.doSum();
	}

}
