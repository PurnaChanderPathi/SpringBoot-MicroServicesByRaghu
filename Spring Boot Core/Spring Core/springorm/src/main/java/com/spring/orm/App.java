package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entity.Student;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		
		/*
		 * Student student = new Student(122,"Chandu", "Kochi"); int result =
		 * studentDao.insert(student); System.out.println("Insertion done : "+result);
		 */
		 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go)
        {
        System.out.println("PRESS 1 for add new Student");
        System.out.println("PRESS 2 for Display AllStudent");
        System.out.println("PRESS 3 for get details of Single Student");
        System.out.println("PRESS 4 to Delete Student");
        System.out.println("PRESS 5 for Update Student");
        System.out.println("Press 6 to Exit");
        try {
        	int input = Integer.parseInt(br.readLine());
        	switch(input)
        	{
        	case 1:
        	//add a new Student
        		//Taking inputs from Users
        		System.out.println("Enter id :");
        		 int uId = Integer.parseInt( br.readLine());
        		 
        		 System.out.println("Enter Name");
        		 String uName = br.readLine();
        		 
        		 System.out.println("Enter City Name");
        		 String uCityName = br.readLine();
        		 
        		 //Creating Student Object and Setting Value
        		 Student s = new Student();
        		 s.setStudentId(uId);
        		 s.setStudentName(uName);
        		 s.setCity(uCityName);
        		 
        		 //saving Student object in database by calling insert Method of StudentDao
        		 int r = studentDao.insert(s);
        		 System.out.println(r+ ": Students Inserted");
        		 System.out.println("****************************************");
        		 System.out.println();
        	break;
        	case 2:
        		//Display all Students
        		System.out.println("*************************************");
        		List<Student> allStudents = studentDao.getAllStudents();
        		for(Student st:allStudents)
        		{
        			System.out.println("id :"+st.getStudentId());
        			System.out.println("Name :"+st.getStudentName());
        			System.out.println("City :"+st.getCity());
        			System.out.println("_________________________________");
        		}
        		System.out.println("*************************************");
        	break;
        	case 3:
        		//get Details of single Student
        		System.out.println("Enter id :");
       		 int userId = Integer.parseInt( br.readLine());
       		 Student student = studentDao.getStudent(userId);
       		System.out.println("id :"+student.getStudentId());
			System.out.println("Name :"+student.getStudentName());
			System.out.println("City :"+student.getCity());
			System.out.println("_________________________________");
        	break;
        	case 4:
        		//delete Student
        		System.out.println("Enter user id :");
          		 int deleteUser = Integer.parseInt( br.readLine());
          		 studentDao.deleteStudent(deleteUser);
          		 System.out.println("Student Deleted");
        	break;
        	case 5:
        		//update Student
				
				  System.out.println("Enter id :"); int updateId = Integer.parseInt(
				  br.readLine());
				  
				  System.out.println("Enter Name"); String updateName = br.readLine();
				  
				  System.out.println("Enter City Name"); String updateCityName = br.readLine();
				  
				  //Creating Student Object and Setting Value
				  Student update = new Student();
				  update.setStudentId(updateId);
				  update.setStudentName(updateName);
				  update.setCity(updateCityName);
				  
				  //saving Student object in database by calling insert Method of StudentDao
				   studentDao.updateStudent(update);
				  System.out.println("Students Updated ");
				  System.out.println("****************************************");
				  System.out.println();
				 
        		
        	break;
        	case 6:
        		//Exit
        		go=false;
        	break;
        	
        	}
		} catch (Exception e) {
			System.out.println("Invalid input try with another one  ...!");
			System.out.println(e.getMessage());
		}
        }
        System.out.println("Thankyou for using my Application");
    }
}
