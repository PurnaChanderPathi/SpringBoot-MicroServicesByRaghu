package PojoJavaBean;

public class Program1 {

	public static void main(String[] args) {
		
		Employee e = new Employee();
		e.setId(33);
		e.name = "Chandu";
		e.salary = 100000.0;
		
		System.out.println(e.getId());
		System.out.println(e.name);
		System.out.println(e.salary);
	}

}
