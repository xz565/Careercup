package chp11_SortingAndSearching;

/*
 * Given a sorted array of n integers that has been rotated 
 * an unknown number of times, give an O(log n) algorithm that 
 * finds an element in the array. You may assume that the array 
 * was originally sorted in increasing order.
 * 
 * EXAMPLE:
 * Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 * Output: 8 (the index of 5 in the array)
 */
public class Question11_3 {

	static int findElement(int[] array, int num, int left, int right) {
		if(left < right) {
			int middle = (left + right) / 2;
			if(array[middle] == num) return middle;
			
			int findLeft = findElement(array, num, left, middle);
			if(findLeft != -1) return findLeft;
			
			int findRight = findElement(array, num, middle + 1, right);
			if(findRight != -1) return findRight;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.print(findElement(array, 16, 0, array.length - 1));
	}
}
