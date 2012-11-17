package chapter9;

public class Fibonacci {

	public static long badFib(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		else return badFib(n - 1) + badFib(n - 2);
	}
	
	static long[] cache = new long[100];
	public static long Fib(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		/*
		if(cache[n] != 0) return cache[n];
		else cache[n] = Fib(n - 1) + Fib(n - 2);
		return cache[n];
		*/
		if(cache[n] == 0) cache[n] = Fib(n - 1) + Fib(n - 2);
		return cache[n];
	}
	
	public static long Fib2(int n) {
		if(n < 0) return -1;
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		int tmp1 = 0;
		int tmp2 = 1;
		int currt = tmp1 + tmp2;
		
		for(int i = 3; i <= n; i++) {
			tmp1 = tmp2;
			tmp2 = currt;
			currt = tmp1 + tmp2;
		}
		
		return currt;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(Fib(45));
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
		
		start = System.currentTimeMillis();
		System.out.println(Fib2(45));
		end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
		
		start = System.currentTimeMillis();
		System.out.println(badFib(45));
		end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
	}
}
