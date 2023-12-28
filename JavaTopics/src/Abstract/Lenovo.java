package Abstract;

public class Lenovo implements Laptop {

	@Override
	public void copy() {
		System.out.println("Copy");
		
	}

	@Override
	public void paste() {
		System.out.println("Paste");
		
	}

	@Override
	public void cut() {
		System.out.println("Cut");
		
	}

	@Override
	public void keyboard() {
		System.out.println("Keyboard");
		
	}

}
