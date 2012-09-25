package chapter9;

/*
 * A child is running up a staircase with n steps,
 * and can hop either 1 step, 2 steps or 3 steps at a time.
 * Implement a method to count how many possible ways
 * the child can run up the stairs.
 */
public class Question9_1 {

	static int countWays(int n) {
		if(n < 0) return 0;
		else if(n == 0) return 1;
		else {
			return countWays(n-1) + countWays(n-2) + countWays(n-3);
		}
	}
	
	static int[] count = new int[100];
	static int countWays2(int n) {
		if(n < 0) return 0;
		if(n == 0) return 1;
		if(count[n] == 0) count[n] = countWays2(n-1) + countWays2(n-2) + countWays2(n-3);
		return count[n];
	}
	
	public static void main(String[] args) {
		System.out.println(countWays2(35));
		System.out.println();
		System.out.println(countWays(35));
	}
}
