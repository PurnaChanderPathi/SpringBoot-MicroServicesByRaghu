package Abstract;


public class User 
{
	public static void main(String[] args) {
		
//		Lenovo lenovo = new Lenovo(); // here when you try to open copy() method lenovo class will open and show method implementation
//		lenovo.copy();
//		lenovo.paste();
		
		Laptop lenovo = new Lenovo(); // here when you try to open copy() method Laptop interface will open and hide method implementation
		lenovo.copy();
		lenovo.paste();
	}
}

