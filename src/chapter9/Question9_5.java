package chapter9;

import java.util.LinkedList;

/*
 * Write a method to compute all permutations of a string
 */
public class Question9_5 {

	static LinkedList<String> calcPermutation(String str) {
		LinkedList<String> newPerms = new LinkedList<String>();
		if(str == null) return newPerms;
		
		if(str.length() == 1) {
			newPerms.add(str);
			return newPerms;
		}
		
		char first = str.charAt(0);
		LinkedList<String> permutations = calcPermutation(str.substring(1));
		for(String s : permutations) {
			for(int i = 0; i <= s.length(); i++) {
				String newStr = insertAt(i, first, s);
				newPerms.add(newStr);
			}
		}
		return newPerms;
	}
	
	static String insertAt(int pos, char ch, String str) {
		String head = str.substring(0, pos);
		String tail = str.substring(pos);
		return head + ch + tail;
	}
	
	// found this cool code on the BBS
	public static void permutateString(String s, String tgs){
		int last = tgs.length();

		if (last == 0){
			System.out.println(s);
			return;
		}

		for (int i = 0; i < last; i++ ){
			permutateString(s + tgs.charAt(i), tgs.substring(0, i) + tgs.substring(i+1));
		}
	}
	
	public static void main(String[] args) {
		String str = "Aporia";
		LinkedList<String> perms = calcPermutation(str);
		System.out.println(perms);
		System.out.println(perms.size());
	}
}