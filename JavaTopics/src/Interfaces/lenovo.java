package Interfaces;

public class lenovo implements Laptop {

	@Override
	public void copy() {
		System.out.println("Lenovo Copy Code");		
	}

	@Override
	public void paste() {
		System.out.println("Lenovo paste Code");
		
	}

	@Override
	public void cut() {
		System.out.println("Lenovo cut Code");
		
	}

	@Override
	public void keyboard() {
		System.out.println("Lenovo keyboard Code");
		
	}
	
	public void camera()
	{
		System.out.println("Lenovo camera Code");
	}
	
	@Override
	public void security()
	{
		System.out.println("Lenovo Security Code");
	}

}
