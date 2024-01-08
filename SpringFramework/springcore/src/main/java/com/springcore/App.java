 package com.springcore;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/config.xml");
        Student student =  (Student) context.getBean("Student1");
        Student student2 = context.getBean("Student2",Student.class);
        Student student3 = context.getBean("Student3",Student.class);
       System.out.println(student);
       System.out.println(student2);
       System.out.println(student3);
        
    }
}
