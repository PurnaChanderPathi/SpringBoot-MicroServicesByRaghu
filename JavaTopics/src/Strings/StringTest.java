package Strings;

public class StringTest {

	public static void main(String[] args) {
		String s1=  "Chandu"; // Stores in StringPool Memory 
		String s2 = new String("Chandu"); // Stores in java Heap Memory
		String s3 = "Chandu";
		String s4 = new String("Chandu");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2); // Compares Address in String
		System.out.println(s1==s3); // Compares Address in String // 
		System.out.println(s2==s4); // Compares Address in String
		System.out.println(s1.equals(s2)); // Compares Data in String
		
		// Here if we assign Data to String Directly with out creating object then data stores in String Pool Memory
		// Here if we assign Data by creating object then data stores in Java Heap Memory
		// in String Pool if the same data is stored twice then it will save in the same address only
		// in Java Heap if the same data is stored twice then it will create another object and save in different address
		

	}

}
