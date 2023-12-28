package Strings;

public class StringTest2 {

	public static void main(String[] args) {
		
		String s1 = "HeLlo";
		String s2 = "hello";
		String s3 = "HELLO";
		
		System.out.println(s1.equals(s3));
		System.out.println(s1.equalsIgnoreCase(s3));
		System.out.println(s1.contains("L"));
		System.out.println(s1.startsWith("eL"));
		System.out.println(s1.startsWith("He"));
		System.out.println(s2.endsWith("o"));
	}
}
