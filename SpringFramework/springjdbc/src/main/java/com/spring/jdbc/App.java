package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.deo.StudentDeo;
import com.spring.jdbc.deo.StudentDeoImpl;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program started...!" );
        
        // spring jdbc => jdbcTemplate
        
       // ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        //Call Java jdbcConfig.java File
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        // to call xml file path
        //JdbcTemplate template = context.getBean("JdbcTemplate",JdbcTemplate.class);
        
        //insert query
       // String query = "insert into student(id,name,city) values(?,?,?)";
        
        //fire query
       // int result = template.update(query,33,"Krishna","Vizag");
       // System.out.println("Number of records inserted :"+ result);
        StudentDeoImpl studentDeoo= context.getBean("studentDeo",StudentDeoImpl.class);
        
          //insert
//          Student student= new Student();
//          student.setId(33);
//          student.setName("Chandu");
//          student.setCity("Vizag");
//        int result = studentDeoo.insert(student);
//        System.out.println("Students added : "+result);
//        
//        //update
//        Student student= new Student();
//        student.setId(35);
//        student.setName("PathiPurnaChander");
//        student.setCity("Goa");
//        int result = studentDeoo.change(student);
//        System.out.println("Data Changed : "+result);
        
//        //delete
//        Student student= new Student();
//        student.setId(35);
//        int result = studentDeoo.delete(student);
//        System.out.println("deleted Data : "+result);
        
//        //Fetch single Student
//        Student student2 = studentDeoo.getStudent(35);
//        System.out.println("Fetcted Data : "+student2);
        
        //Fetching all Students
        List<Student> allStudents = studentDeoo.getAllStudents();
       for(Student s:allStudents)
       {
    	   System.out.println(s);
       }
    }
    
}
