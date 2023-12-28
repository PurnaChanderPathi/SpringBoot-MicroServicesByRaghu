package Strings;

public class StringBuilderOperations {
	
	public static void main(String[] args) {
		
		StringBuilder sb1 = new StringBuilder("Purna");
		sb1.insert(5, "Chander"); // PurnaChander
		//sb1.deleteCharAt(0); // P
		//sb1.delete(0, 5); // Purna
		//sb1.reverse(); //rednahCanruP
		StringBuilder sb2 = new StringBuilder();
		//System.out.println(sb2.capacity()); //16 if no String is declared
		//System.out.println(sb1.capacity());  //21 if String is given 
		sb2.ensureCapacity(100); // increase capacity to 100
		System.out.println(sb2.capacity());
		System.out.println(sb1); 
	}

}
