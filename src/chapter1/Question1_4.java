package chapter1;

import java.util.Arrays;

/* 
 * Write a method to decide if two strings are anagrams or not
 */
public class Question1_4 {

	/* time: O(n) space: O(1)*/
	public static boolean isAnagram(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		/* count chars for each string */ 
		int[] charSet1 = countChar(str1);
		int[] charSet2 = countChar(str2);
		/* compare two char set to see if anagram */
		for(int i = 0; i < charSet1.length; i++) {
			if(charSet1[i] != charSet2[i])
				return false;
		}
		return true;
	}
	
	/* also, assume ACSII character string */
	public static int[] countChar(String str) {
		int[] charSet = new int[256];
		for(int i = 0; i < str.length(); i++) {
			charSet[str.charAt(i)]++;
		}
		return charSet;
	}
	
	public static boolean isAnagram2(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		/*
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		str1 = new String(chars1);
		str2 = new String(chars2);
		*/
		str1 = sort(str1);
		str2 = sort(str2);
		return str1.equals(str2);
	}
	
	public static String sort(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("",""));
		System.out.println(isAnagram(" "," "));
		System.out.println(isAnagram("asdfghjkl","asdfghjko"));
		System.out.println(isAnagram("asdfghjkl","asdfghjkl"));
		System.out.println();
		System.out.println(isAnagram2("",""));
		System.out.println(isAnagram2(" "," "));
		System.out.println(isAnagram2("asdfghjkl","asdfghjko"));
		System.out.println(isAnagram2("asdfghjkl","asdfghjkl"));
	}
}
