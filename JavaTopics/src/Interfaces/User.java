package Interfaces;

public class User {

	public static void main(String[] args) {
		lenovo l = new lenovo();
		l.camera();
		l.copy();
		l.cut();
		l.keyboard();
		l.security();
		
		//until java7
		 Laptop.audio(); // mathod with static in interface can directly call with interface Name(Laptop)
		
		
		Hp h = new Hp();
		h.Printing();
		h.security();
		
		
	
		
		
		
	}

}
