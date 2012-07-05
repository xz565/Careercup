package chapter5;

public class Examples {

	static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}
	
	static int setBit(int num, int i) {
		return num | (1 << i);
	}
	
	static int clearBit(int num, int i) {
		return num & ~(1 << i);
	}
	
	// clear all bits from most significant bit through i (inclusive)
	static int clearBitsMSBtoroughI(int num, int i) {
		int mask = (1 << (i + 1)) - 1;
		return num & mask;
	}
	
	// clear all bits from i through 0 (inclusive)
	static int clearBitsIthrough0(int num, int i) {
		int mask = ~((1 << (i + 1)) - 1);
		return num & mask;
	}
	
	/* write a function to count number 
	 * of 1s in a binary form of an Integer
	 */
	
	// Time complexity O(lgn), Space O(1)
	static int countOnes(int num) {
		int count = 0;
		while(num > 0) {
			if(num % 2 == 1) count++;
			num /= 2;
		}
		return count;
	}
	
	
	static int countOnes2(int num) {
		return 0;
	}
		
	public static void main(String[] args) {
		System.out.println("0 " + countOnes(0));
		System.out.println("1 " + countOnes(1));
		System.out.println("22 " + countOnes(22));
		System.out.println("Integer.MAX_VALUE " + countOnes(Integer.MAX_VALUE));
	}
}