package Strings;

public class Test {

	public static void main(String[] args) {
		/*
		 *  String are Immutable
		 *  StringBuffer & StringBuilder are Mutable
		 *  StringBuffer is Synchronized
		 *  StringBuilder is deSynchronized
		 */
		StringBuffer sb1 = new StringBuffer("Purna"); // id = 24 
		StringBuffer sb2 = new StringBuffer("Purna"); // id = 36
		System.out.println(sb1 == sb2);  // here we have diff address 24==36 // false
		
		sb1 = sb1.append("Chander"); //24
		System.out.println(sb1 == sb2); // here we have diff address 24==36 // false
		
		StringBuffer sb3 = new StringBuffer("PurnaChander"); // id = 47
		System.out.println(sb1 == sb3); // here we have diff address 24==47 // false
		
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println();
		
		
		String s1 = "Purna";	// id = 55	
		String s2 = "Purna";	// id = 55
		System.out.println(s1==s2); //here it will check address 55 == 55 true
		
		 s1 = s1 + "chander"; //purnachander // id = 59
		 System.out.println(s1==s2); // here when data changed address will change 59==55 // false
		 
		 String s3 = "Purnachander"; // id = 61
		 System.out.println(s1==s3); //  here when data changed address will change 59==61 // false
		 
		 System.out.println();
		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 System.out.println();
		 
		 StringBuilder sb4 = new StringBuilder("Purna"); // id = 34 
		 StringBuilder sb5 = new StringBuilder("Purna"); // id = 35
		 System.out.println(sb4 == sb5);  // here we have diff address 34==35 // false
			
		 sb4 = sb4.append("Chander"); //34
			System.out.println(sb4 == sb5); // here we have diff address 34==35 // false
			
			StringBuilder sb6 = new StringBuilder("PurnaChander"); // id = 49
		 System.out.println(sb4 == sb6); // here we have diff address 34==49 // false
			

		

	}

}
