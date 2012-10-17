package chapter16;

public class ThreadExample implements Runnable{
	public int count = 0;
	
	public void run() {
		System.out.println("ThreadExample starting...");
		while(count < 5) {
			try{
				Thread.sleep(500);
			} catch (Exception e) {
				
			}
			count++;
			System.out.println("Increasing i by 1");
		}
		System.out.println("ThreadExample terminated");
	}
	
	public static void main(String[] args) {
		ThreadExample instance = new ThreadExample();
		Thread thread = new Thread(instance);
		thread.start();
		
		while(instance.count != 5) {
			try{
				Thread.sleep(250);
				System.out.println("waiting...");
			} catch (Exception e) {
				
			}
		}
	}
}
