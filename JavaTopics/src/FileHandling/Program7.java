package FileHandling;
// By using FileWriter

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program7 {

	public static void main(String[] args) throws IOException {
//		//to insert data
//	File file = new File("./sample.txt");
//	if(file.exists())
//		file.delete();
//	System.out.println(file.createNewFile());
//	String s = "Hello Eidiko";
//
//	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//	bw.write(s);
//	bw.flush();
//	}
	
	//to Update data
File file = new File("./sample.txt");

String ExistingText = new String();
String line = "";
BufferedReader br = new BufferedReader(new FileReader(file));
while((line = br.readLine()) != null)
 ExistingText += line +"\n";
String s = "Welcome to eidiko";

BufferedWriter bw = new BufferedWriter(new FileWriter(file));
bw.write(ExistingText + s);
bw.flush();

}
}
