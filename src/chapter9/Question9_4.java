package chapter9;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Write a method to return all subsets of a set.
 */
public class Question9_4 {

	static ArrayList<ArrayList<Integer>> findSubsets(ArrayList<Integer> set) {
		if(set.size() == 0) {
			ArrayList<Integer> empty = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> emptySets = new ArrayList<ArrayList<Integer>>();
			emptySets.add(empty);
			return emptySets;
		}
		
		int first = set.remove(0);
		
		ArrayList<ArrayList<Integer>> subSets = findSubsets(set);
		//ArrayList<ArrayList<Integer>> newSets = (ArrayList<ArrayList<Integer>>)subSets.clone();
		// manually clone 
		
		ArrayList<ArrayList<Integer>> newSets = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> al : subSets) {
			ArrayList<Integer> newAl = new ArrayList<Integer>();
			for(int i : al) {
				newAl.add(i);
			}
			newSets.add(newAl);
		}
				
		for(ArrayList<Integer> al : newSets)
			al.add(first);
		
		subSets.addAll(newSets);
		return subSets;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
		ArrayList<ArrayList<Integer>> subSets = findSubsets(set);
		//System.out.println(subSets);
		System.out.println("size = " + subSets.size());
		for(ArrayList<Integer> al : subSets) {
			System.out.println(al);
		}
	}
}
