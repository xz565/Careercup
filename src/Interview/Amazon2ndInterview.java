package interview;

/*
 * Given a sorted element of size n that should contain unique integers between 0 and n (0 & n inclusive). 
 * Identify the missing element.
 * eg) n = 5
 *  array = 0, 1, 2, 4, 5
 *  array = 0, 1, 2, 3, 4
 *  
 * How many possible situation is there?
 * Answer: if no missing element, the array is 0, 1, 2, 3, 4, ..., n
 *         now there is missing one which could be anyone
 *         so there are n possible ways	
 */

public class Amazon2ndInterview {

	// A liner algorithm
	/*
	 * Iterate through the array, check the different
	 * between current element and the next element.
	 */
	public static int findMissing(int[] arr, int n) {
		if(arr == null)
			return -1;
		
		if(arr.length != n)
			return -1;
		
		if(arr[0] == 0 && arr[n-1] == n-1)
			return n;
		
		if(arr[0] == 1 && arr[n-1] == n)
			return 0;
		
		for(int i = 0; i < arr.length - 1; i++) {
			int diff = arr[i+1] - arr[i];
			if(diff > 1) {
				return arr[i] + 1; // missing value
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4};
		System.out.println(findMissing(arr, 5));
		int[] arr2 = {1, 2, 3, 4, 5};
		System.out.println(findMissing(arr2, 5));
		int[] arr3 = {0, 1, 2, 4, 5};
		System.out.println(findMissing(arr3, 5));
	}
}
