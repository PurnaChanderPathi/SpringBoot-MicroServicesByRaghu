package com.springcore.lifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		AbstractApplicationContext context  = new ClassPathXmlApplicationContext("com/springcore/lifeCycle/config.xml");
		//registering shutdown hook
		context.registerShutdownHook();
//		Samosa s1 = context.getBean("Samosa",Samosa.class);
//		System.out.println(s1);
//		 
//		
//		System.out.println("########################");
//		
//		Pepsi s2 = context.getBean("Pepsi",Pepsi.class);
//		System.out.println(s2);
		 Pizza pizza= context.getBean("Pizza", Pizza.class);
		 System.out.println(pizza);

	}

}
