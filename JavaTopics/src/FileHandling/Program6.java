package FileHandling;
// By using FileWriter

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Program6 {

	public static void main(String[] args) throws IOException {
	File file = new File("./sample.txt");
	if(file.exists())
		file.delete();
	System.out.println(file.createNewFile());
	String s = "Chandu";
	FileWriter fw = new FileWriter(file);
	fw.write(s);
	fw.flush();
	}
}
