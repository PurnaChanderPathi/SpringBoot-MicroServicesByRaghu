package ExceptionHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Program1 {

	public static void main(String[] args) throws FileNotFoundException {
		

	
	//stacktrace
	/*
	 * Exception name 
	 * Exception message
	 * which line number
	 * Methods info
	 */
	
		System.out.println("Program Excusion Started");
		int fNumber = 5;
		int lNumber = 0;
		int result = 0;
		
		File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\ViratVsNZ.jpg");
		FileInputStream fis = new FileInputStream(file);
		System.out.println(fis);
		
		try {
			result = fNumber/lNumber;
		} catch (ArithmeticException e) {
			System.out.println(Arrays.toString(e.getStackTrace())); //write a logic to enter this message in log file
			throw e; // throws exception to java to handle it
		}
		finally {
			System.out.println("Finally Block"); 
		}
		System.out.println("Output is " + result);
		System.out.println("Program Excusion Ended");
		
	}
	
}


//Try is mandetory key work
//finally is optional keywork
//catch is optional key work when finally is declared
//try is mandatory for catch and finnaly without try we cannot declare catch and finally
