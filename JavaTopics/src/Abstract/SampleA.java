package Abstract;

import Interfaces.Laptop;

public abstract class SampleA implements Laptop {
	public void copy()
	{
		System.out.println("Copy code");
	}
	
	public void paste()
	{
		System.out.println("Paste code");
	}

}
