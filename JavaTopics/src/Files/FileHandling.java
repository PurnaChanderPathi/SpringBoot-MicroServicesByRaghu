package Files;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileHandling {

	public static void main(String[] args) throws IOException {

		//File fis = new File("E:\\TestFiles\\Resume.txt"); // to give file path
		//File fis = new File("./Resume.txt"); to take default project location use this "./"
		
		// To Create and Delete and IfExist
//		if(fis.exists())
//			fis.delete();
//		System.out.println( fis.createNewFile());
		//System.out.println(fis.exists()); // to check file exist
		//System.out.println(fis.createNewFile()); //to create file
		//System.out.println(fis.delete()); //To delete file
		
		// To check file is hidden
		//System.out.println(fis.isHidden());
		
		
		// To Create Folder
		File fis = new File("E:\\TestFiles\\Resume.txt");
		//System.out.println(fis.mkdir()); // to create one Folder
		//System.out.println(fis.mkdirs()); // To create multiple folders like  "\\TestFiles\\Resources\\Media\\Photos" at a time
//		if(fis.exists())
//			fis.delete();
//			System.out.println(fis.mkdirs());
		//System.out.println(Arrays.toString(fis.list())); // To List all the folders and files
		//System.out.println(Arrays.toString(fis.listFiles())); // To List all the folders and files with filepaths
		//System.out.println(fis.getName()); // To get fileName
		//System.out.println(fis.getAbsolutePath()); // To get full path to use some where else
		//System.out.println(new Date( fis.lastModified())); // To get Exact last modified Date
		//System.out.println(fis.isFile()); 
		System.out.println(fis.isDirectory());

	}

}
