package leetcode;

import java.util.HashSet;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		HashSet<Integer> elements = new HashSet<Integer>();
		for(int i : numbers) {
			elements.add(i);
		}

	    for(int i = 0; i < numbers.length; i++) {
	    	int diff = target - numbers[i];
	        if(elements.contains(diff)) {
	        	for(int j = 0; j < numbers.length; j++) {
	        		if(numbers[j] == diff && i != j) {
	        			if(i < j) {
	        				int[] result = {i+1, j+1};
	        			    return result;
	        			} else {
	        				int[] result = {j+1, i+1};
	        				return result;
	        			}
	                }
	            }
	        }
	    }
        
	    int[] result = {0, 0};
	    return result;
    }
}