package chapter5;

public class SomeExamples {

	static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}
	
	public static void main(String[] args) {
		//System.out.println(getBit(4, 3));
		//System.out.println(1 << 5);
		System.out.println(Integer.reverse(1));
	}
}
