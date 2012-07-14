package chapter17;

/*
 * Write a function to swap a number in place
 * (that is, without temporary variables).
 */
public class Question17_1 {

	static void swap(int a, int b) {
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println(a + " " + b);
	}
	
	static void swap2(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + " " + b);
	}
	
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		swap(a, b);
		swap2(a, b);
	}
}
