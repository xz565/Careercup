package chp11_SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * Write a method to sort an array of strings so that 
 * all the anagrams are next to each other.
 */

// This is a O(nlgn) solution for this Problem
public class Question11_2 implements Comparator<String>{
	static String sortStr(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	@Override
	public int compare(String o1, String o2) {
		return sortStr(o1).compareTo(sortStr(o2));
	}
	
	// a faster solution using hashing
	public static void sort(String[] array) {
		HashMap<String, LinkedList<String>> hash = 
				new HashMap<String, LinkedList<String>>();
		
		for(String str : array) {
			String keyStr = sortStr(str);
			if(hash.containsKey(keyStr)) {
				hash.get(keyStr).add(str);
			} else {
				LinkedList<String> list = new LinkedList<String>();
				list.add(str);
				hash.put(keyStr, list);
			}
		}
		
		int idx = 0;
		for(String key : hash.keySet()) {
			for(String str : hash.get(key)) {
				array[idx] = str;
				idx++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		String[] array = {"asdfg", "zxcvb", "qwert", "gfdsa", "trewq", "vcbxz"};
		Arrays.sort(array, new Question11_2());
		for(String s : array)
			System.out.println(s);
		System.out.println();
		
		String[] array2 = {"asdfg", "zxcvb", "qwert", "gfdsa", "trewq", "vcbxz"};
		sort(array2);
		for(String s : array)
			System.out.println(s);
	}

}
