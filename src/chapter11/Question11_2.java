package chapter11;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Write a method to sort an array of strings so that 
 * all the anagrams are next to each other.
 */
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
	
	public static void main(String[] args) {
		String[] array = {"asdfg", "zxcvb", "qwert", "gfdsa", "trewq", "vcbxz"};
		Arrays.sort(array, new Question11_2());
		for(String s : array) {
			System.out.println(s);
		}
	}

}
