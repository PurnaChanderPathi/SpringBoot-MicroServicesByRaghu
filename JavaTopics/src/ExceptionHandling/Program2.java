package ExceptionHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Program2 {
	public static void main(String[] args) throws IOException {
		File file = new File("./sample.txt");
		if(!file.exists())
			System.out.println(file.createNewFile());
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String text = new String();
		String line = new String();
		while((line =br.readLine()) != null)
		{
			System.out.println(line);
			text += line + "\n";
		}
		System.out.println();
		System.out.println(text);
		fr.close();
		br.close();
	}

}
