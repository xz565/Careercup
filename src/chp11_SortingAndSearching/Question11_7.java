package chp11_SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

public class Question11_7 implements Comparator<People>{

	@Override
	public int compare(People o1, People o2) {
		if(o1.height > o2.height) return 1;
		else if(o1.height < o2.height) return -1;
		else return 0;
	}

	static int computeNum(People[] peoples) {
		// sort by height
		sortByHeight(peoples);
		
		// find largest subset by weight
		return findLargestSubset(peoples);
	}
	
	static void sortByHeight(People[] ps) {
		Arrays.sort(ps, new Question11_7());
	}
	
	static int findLargestSubset(People[] ps) {
		int maxLen = 0;
		int currtLen = 0;
		int prevWeight = 0;
		
		for (int i = 0; i < ps.length; i++) {
			int w = ps[i].weight;
			
			if(w > prevWeight) {
				currtLen++;
			} else {
				if(currtLen > maxLen)
					maxLen = currtLen;
				currtLen = 1;
			}
			prevWeight = w;
		}
		
		return currtLen > maxLen ? currtLen : maxLen;
	}
	
	public static void main(String[] args) {
		People[] ps = {new People(65, 100), new People(70, 150), new People(56, 90), new People(75, 190), 
				new People(60, 95), new People(68, 110), };
		System.out.print(computeNum(ps));
	}
}

class People {
	int height;
	int weight;
	
	public People(int h, int w) {
		height = h;
		weight = w;
	}
	
	public String toString() {
		return "P:(" + height + " " + weight + ")" + " ";
	}
}