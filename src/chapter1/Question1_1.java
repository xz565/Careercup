package chapter1;

import java.util.Arrays;

/* 
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */
public class Question1_1 {
	/*
	 * Assume ASCII character set, 8 bits, 256 chars If assuming Unicode, 16bits
	 * with much more chars
	 */
	// method with extra buffer
	public static boolean isAllUnique(String str) {
		boolean[] charSet = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (charSet[c])
				return false;
			else
				charSet[c] = true;
		}
		return true;
	}

	// method without additional data structure
	public static boolean isAllUnique2(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == chars[i + 1])
				return false;
		}
		return true;
	}

	// a bitwise solution
	// assume the string only uses lower case letters a through z
	public static boolean isUniqueChars(String str) {
		if(str.length() > 256) return false;
		
		int checker = 0;
		for(int i = 0; i < str.length();  i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] strs = { "asdfghjklASDFGHJKL!@#$%^&*()",
				"asdfghjklqwertyuiopf", "", "~!@#$%^&*()_+ASDFGHJKL;" };
		for (String str : strs)
			System.out.println(isAllUnique(str));
		System.out.println();
		for (String str : strs)
			System.out.println(isAllUnique2(str));
		System.out.println();
		String[] strs2 = { "asdfghjkl", "asdfghjklqwertyuiopf", ""};
		for (String str : strs2)
			System.out.println(isUniqueChars(str));
	}
}