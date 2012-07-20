package chapter17;

public class Question17_3 {

	// This is not a right solution
	static int findTrailZeros(int n) {
		int lsb = 1;
		int zeroCount = 0;
		for(int i = 2; i <= n; i++) {
			int product = lsb * i;
			/////System.out.println(lsb + " " + i + " " + product);
			while(product % 10 == 0) {
				zeroCount++;
				product = product / 10;
			}
			lsb = product - 1000 * (product / 1000);
		}
		return zeroCount;
	}
	
	public static void main(String[] args) {
		/*
		System.out.println(findTrailZeros(1));
		System.out.println(findTrailZeros(2));
		System.out.println(findTrailZeros(5));
		System.out.println(findTrailZeros(10));
		System.out.println(findTrailZeros(15));
		System.out.println(findTrailZeros(20));
		*/
		System.out.println(findTrailZeros(125));
	}
}
