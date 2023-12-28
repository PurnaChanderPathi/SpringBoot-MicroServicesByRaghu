package FileHandling;
// By using FileInputSteam

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Program1 {

	public static void main(String[] args) throws IOException {
	File file = new File("./sample.txt");
	if(!file.exists())
		System.out.println(file.createNewFile());
	
	FileInputStream fis = new FileInputStream(file);
	int asciiCode;
	String text = new String(); // method 2
	while((asciiCode = fis.read()) != -1)
	{
		text += String.valueOf((char)asciiCode); //method 2
		//System.out.print((char)asciiCode);		
	}
	System.out.println();
	System.out.println(text);
	fis.close();
	}
}
