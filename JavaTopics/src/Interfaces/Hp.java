package Interfaces;

public class Hp implements Laptop {

	@Override
	public void copy() {
		System.out.println("Hp Copy Code");		
	}

	@Override
	public void paste() {
		System.out.println("Hp paste Code");
		
	}

	@Override
	public void cut() {
		System.out.println("Hp cut Code");
		
	}

	@Override
	public void keyboard() {
		System.out.println("Hp keyboard Code");
		
	}
	
	public void Printing()
	{
		System.out.println("Hp printing Code");
	}
	
	@Override
	public void security()
	{
		System.out.println("Hp Security Code");
	}
	


}
