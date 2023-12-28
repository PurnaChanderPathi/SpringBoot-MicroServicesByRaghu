package Interfaces;

public interface Laptop {
	
	public void copy();
	
	public void paste();
	
	public void cut();
	
	public void keyboard();
	
	default void security() // can implement with in the interface if we not implemented also no error will show
	{
		commonCode();
		System.out.println("Laptop Security");
	}
	
	static void audio() // can directly call without creating object
	{
		commonCode();
		System.out.println("Laptop audio code");
	}
	
	private static void commonCode() //we use this method to write common code which is used in both default and static we write here and call this method in both methods
	{
		System.out.println("Common Code");
	}

}
