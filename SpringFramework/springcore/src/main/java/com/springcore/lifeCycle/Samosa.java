package com.springcore.lifeCycle;

public class Samosa {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("Setting Price");
		this.price = price;
	}

	public Samosa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Samosa [price=" + price + "]";
	}
	
	public void hey()
	{
		System.out.println("Inside Init Method");
	}
	
	public void bye()
	{
		System.out.println("Inside Destroy Method");
	}
	
	

}
