package MultiThreading;

public class SynchronizedTest {
	public static void main(String[] args) throws InterruptedException {
		BrickDairy bd = new BrickDairy();
		Runnable r1 = () -> {
			for(int i =0; i<10000; i+=50)
			{
				//Unloading the 50 bricks
				bd.incrementBreakCount();
			}
		};
		
		Runnable r2 = () -> {
			for(int i =0; i<15000; i+=50)
			{
				//Unloading the 50 bricks
				bd.incrementBreakCount();
			}
		};
		
		Runnable r3 = () -> {
			for(int i =0; i<5000; i+=50)
			{
				//Unloading the 50 bricks
				bd.incrementBreakCount();
			}
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
	
		System.out.println(bd.breakCount);
		System.out.println(bd.breakCount2);
	}
}

class BrickDairy
{
	int breakCount = 0;
	int breakCount2 = 0;
	public void incrementBreakCount()
	{
		breakCount2 += 50;
		synchronized(this)
		{
			breakCount += 50;
		}
	}
}