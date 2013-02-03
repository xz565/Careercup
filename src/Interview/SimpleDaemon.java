package interview;

import java.util.concurrent.*;

public class SimpleDaemon implements Runnable {

	@Override
	public void run() {
		try{
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
			
		} catch(InterruptedException e) {
			System.out.println("sleep() interrupted");
		}
	}
	
	public static void main(String[] args) throws Exception {
		for(int i = 0; i < 2; i++) {
			Thread daemon = new Thread(new SimpleDaemon());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All daemons started");
		TimeUnit.MILLISECONDS.sleep(5000);
	}
	
}
