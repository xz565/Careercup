package chapter9;

/*
 * A magic index in an array A[0 ... n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array, write a method to find a magic index, if one exists, in array A.
 * 
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class Question9_3 {

	// a obvious way is to check through all the array, this requires linear time
	
	// because this is a sorted array, we can use binary search recursively
	// Time complexity is O(lgn)
	// assume the values are distinct
	static int findMagic(int[] arr, int start, int end) {
		if(start > end) return -1;
		
		int mid = (start + end) / 2;
		if(arr[mid] == mid) return mid;
		else if(arr[mid] < mid) return findMagic(arr, mid + 1, end);
		else return findMagic(arr, start, mid);
	}
	
	public static void main(String[] args) {
		int[] arr = {-2, -4, 1, 2, 4, 5, 10, 11};
		System.out.print(findMagic(arr, 0, arr.length - 1));
	}
}
