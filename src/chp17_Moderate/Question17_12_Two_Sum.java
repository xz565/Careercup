package chp17_Moderate;

import java.util.Arrays;

/*
 * Design an algorithm to find all pairs of integers
 * within an array which sum to a specified value.
 */

public class Question17_12_Two_Sum {
	// Arrays.sort takes O(nlgn) time, while loop takes linear time
	// So total time complexity is O(nlgn), no space needed
	// There are also O(n^2) time O(1) space
	// AND O(n) time O(n) space solution for this problem
	public static void twoSum(int[] elements, int sum) {
		Arrays.sort(elements);
		int head = 0;
		int tail = elements.length - 1;
		while(head < tail) {
			int s = elements[head] + elements[tail];
			if(s == sum) {
				System.out.println(elements[head] + " " + elements[tail]);
				head++;
				tail--;
			} else {
				if(s < sum) {
					head++;
				} else {
					tail --;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] elems = {4, 6, 9, 2, 0, 1, 2, -2, 4, 9, 13, -3, -9, 3};
		twoSum(elems, 10);
	}

}
