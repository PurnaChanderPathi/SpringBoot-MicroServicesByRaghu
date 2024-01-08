package com.springcore.ci;

public class Addition {
	private int a;
	private int b;
	
	public Addition(double a, double b) 
	{
		this.a=(int) a;
		this.b=(int) b;
		System.out.println("Constructor double");
	}
	
	public Addition(int a, int b) 
	{
		this.a=a;
		this.b=b;
		System.out.println("Constructor Int");
	}
	
	public Addition(String a,String b)
	{
		this.a=Integer.parseInt(a);
		this.b=Integer.parseInt(b);
		System.out.println("Constructor String");
	}
	

	
	public void doSum()
	{
		System.out.println("value of a: "+this.a);
		System.out.println("value of b: "+this.b);
		System.out.println("Sun is :"+(this.a+this.b));
	}

	/*
	 * @Override public String toString() { return "Addition [a=" + a + ", b=" + b +
	 * "]"; }
	 */
	
	

}
