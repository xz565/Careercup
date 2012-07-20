package chapter17;

import java.util.Random;

public class Question17_8 {

	// This is a O(n^3) method
	// Dead at n = 10^4
	static int findMaxSum1(int[] array) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			for(int j = i; j < array.length; j++) {
				int sum = 0;
				for(int k = i; k <= j; k++) {
					sum += array[k];
				}
				max = Math.max(max, sum);
			}
		}
		return max;
	}
	
	// This is a O(n^2) method
	// Dead at n = 10^6
	static int findMaxSum2(int[] array) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			int currtMax = 0;
			for(int j = i; j < array.length; j++) {
				currtMax += array[j];
				max = Math.max(max, currtMax);
			}
		}
		return max;
	}
	
	// This is a O(nlgn) method
	// Run out of Memory before run out of time
	static int findMaxSum3(int[] array, int left, int right) {
		if(left > right) return 0;
		if(left == right) return array[left];
		//if(left == right) return Math.max(0, array[left]);
		
		int middle = (left + right) / 2;
		int lSub = findMaxSum3(array, left, middle);
		int rSub = findMaxSum3(array, middle + 1, right);
		
		int sum = 0;
		int lMax = 0;
		for(int i = middle; i >= left; i--) {
			sum += array[i];
			lMax = Math.max(lMax, sum);
		}
		
		sum = 0;
		int rMax = 0;
		for(int i = middle + 1; i <= right; i++) {
			sum += array[i];
			rMax = Math.max(rMax, sum);
		}
		
		return Math.max(lMax + rMax, Math.max(lSub, rSub));
	}
	
	// Incredible smart algorithm
	static int findMaxSum4(int[] array) {
		int max = 0;
		int maxAtEnd = 0;
		for(int i = 0; i < array.length; i++) {
			maxAtEnd = Math.max(maxAtEnd + array[i], 0);
			max = Math.max(maxAtEnd, max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int LENGTH = 100000000;
		int[] array = new int[LENGTH];
		Random rd = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = rd.nextInt() % 1000;
		}

		long start = System.currentTimeMillis();
		//System.out.print(findMaxSum1(array));
		long end = System.currentTimeMillis();
		System.out.println(" " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		//System.out.print(findMaxSum2(array));
		end = System.currentTimeMillis();
		System.out.println(" " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		System.out.print(findMaxSum3(array, 0, array.length - 1));
		end = System.currentTimeMillis();
		System.out.println(" " + (end - start) + "ms");
		
		start = System.currentTimeMillis();
		System.out.print(findMaxSum4(array));
		end = System.currentTimeMillis();
		System.out.println(" " + (end - start) + "ms");
	}
}