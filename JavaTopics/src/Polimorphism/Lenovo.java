package Polimorphism;


public class Lenovo extends SampleA {

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyboard() {
		// TODO Auto-generated method stub
		
	}
	
	public void copy()
	{
		System.out.println("Lenovo updated Copy code");
	}
	
	public static void main(String[] args) {
		
		Lenovo lenovo = new Lenovo();
		lenovo.copy();
	}




}
