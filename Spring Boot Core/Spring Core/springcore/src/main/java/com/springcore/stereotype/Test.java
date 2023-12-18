package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/stereotype/stereoconfig.xml");
//		Student s1 = context.getBean("student",Student.class);
////		System.out.println(s1);
////		System.out.println(s1.getAddress());
////		System.out.println(s1.getAddress().getClass().getName());
//		System.out.println(s1.hashCode());
//		
//		Student s2 = context.getBean("student",Student.class);
//		System.out.println(s2.hashCode());
		
		Teacher teacher = context.getBean("Teacher",Teacher.class);
		System.out.println(teacher.hashCode());
		
		Teacher teacher1 = context.getBean("Teacher",Teacher.class);
		System.out.println(teacher1.hashCode());

	}

}
