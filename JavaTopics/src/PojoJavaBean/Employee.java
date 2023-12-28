package PojoJavaBean;

public class Employee {

	private int id;
	public String name;
	protected double salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(int id) {
		super();
		this.id = id;
	}
	public Employee() {
		super();
		System.out.println("No Arg constructor is called");
	}
	
	
}
