package Interfaces;

public class Apple implements Laptop {
	
	@Override
	public void copy() {
		System.out.println("Apple Copy Code");		
	}

	@Override
	public void paste() {
		System.out.println("Apple paste Code");
		
	}

	@Override
	public void cut() {
		System.out.println("Apple cut Code");
		
	}

	@Override
	public void keyboard() {
		System.out.println("Apple keyboard Code");
		
	}

}
