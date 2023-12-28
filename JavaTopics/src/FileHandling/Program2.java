package FileHandling;
// by using Scanner

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) throws IOException {
	File file = new File("./sample.txt");
	if(!file.exists())
		System.out.println(file.createNewFile());

// type 1
//		Scanner scanner = new Scanner(file);
//		String text = new String();  //method 2
//		while(scanner.hasNextLine())
//		{
//			//System.out.println(scanner.nextLine());
//			text += scanner.nextLine() + "\n"; //method 2
//		}
//		System.out.println(text); //method 2
//		scanner.close();
	
		// type 2
		FileInputStream fis = new FileInputStream(file);
		Scanner scanner = new Scanner(fis);
		String text = new String();  //method 2
		while(scanner.hasNextLine())
		{
			//System.out.println(scanner.nextLine());
			text += scanner.nextLine() + "\n"; //method 2
		}
		System.out.println(text); //method 2
		scanner.close();
		fis.close();
	}
}
