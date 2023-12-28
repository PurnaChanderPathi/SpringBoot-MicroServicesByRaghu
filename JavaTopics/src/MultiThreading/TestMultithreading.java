package MultiThreading;

public class TestMultithreading {

	public static void main(String[] args) throws InterruptedException {

//		Employee e1 = new Employee("T1");
//		e1.start();
//		
//		Student s1 = new Student();
//		Thread t1 = new Thread(s1,"T2");
//		t1.start();
		
		Runnable r1 = () -> {
			for(int i=0;i<10;i++)
			{
			//System.out.println("Hello " + Thread.currentThread().getName() +" >> "+ Thread.currentThread().getId());
			}
		};
		
			Runnable r2 = () -> {
			for(int i=0;i<15;i++)
			{
			//System.out.println("Hi    " + Thread.currentThread().getName() +" >> "+ Thread.currentThread().getId());
			}
		};
		
		Thread t1 = new Thread(r1,"T1");
		System.out.println(t1.getState());
		Thread t2 = new Thread(r2,"T2");
		t1.start();
		System.out.println(t1.getState());
		//t1.join();
		t1.sleep(10000);
		System.out.println(t1.getState());
		t2.start();
		
		//0 - New
		//1 - Runnable
		//2 - Blocked
		//3 - Waiting (join)
		//4 - Timed Waiting (specific time/sleep)
		//5 - Terminated

		
		//System.out.println(Thread.activeCount());
		//System.out.println(Thread.currentThread().getName());
	}

}

//class Employee extends Thread
//{
//	public Employee(String TName)
//	{
//		super(TName);
//	}
//	@Override
//	public void run()
//	{
//		System.out.println("Hello " + Thread.currentThread().getName() +" >> "+ Thread.currentThread().getId());
//	}
//}
//
//class Student implements Runnable
//{
//	@Override
//	public void run()
//	{
//		System.out.println("Hi " + Thread.currentThread().getName() +" >> "+ Thread.currentThread().getId());
//	}
//}
