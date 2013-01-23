package chp09_RecursionAndDP;

/* Given an infinite number of quarters (25 cents), dimes (10 cents), 
 * nickel (5 cents) and pennies (1 cent), write code to calculate the 
 * number of ways of representing n cents
 */
public class Question9_8 {

	/* A wrong method
	 * when using recursive method, we should watch out for 
	 * the over lap between each sub case
	 *  
	static int calcCents(int num) {
		if(num < 0) return 0;
		else if(num == 0) return 1;
		else {
			return calcCents(num - 1) + calcCents(num - 5) + 
					calcCents(num - 10) + calcCents(num - 25);
		}
	}
	*/
	
	static int calcCents(int num, int denom) {
		int next_denom = 0;
		switch(denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		
		int ways = 0;
		/*
		for(int i = 0; i * denom <= num; i++) {
			ways += calcCents(num - i * denom, next_denom);
		}
		*/
		int i = 0;
		while(i * denom <= num) {
			ways += calcCents(num - i * denom, next_denom);
			i++;
		}
		return ways;
	}
	
	public static void main(String[] args) {
		System.out.println(calcCents(1, 25));
		System.out.println(calcCents(2, 25));
		System.out.println(calcCents(5, 25));
		System.out.println(calcCents(6, 25));
		System.out.println(calcCents(10, 25));
		System.out.println(calcCents(100, 25));
	}
}
