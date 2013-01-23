package chp01_ArraysAndStrings;

/*
 * Assume you have a method isSubstring which 
 * checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check 
 * if s2 is a rotation of s1 using only one call to
 * isSubstring (i.e., "waterbottle" is a rotation of "erbottlewat").
 */
public class Question1_8 {
	
	public static boolean isRotation(String s1, String s2) {
		if(s1.length() ==0 || s2.length() == 0) 
			return true;
		return isSubstring(s1 + s1, s2);
	}
	
	/* check isSubstring using regular expression */
	public static boolean isSubstring(String s1, String s2) {
		return s2.matches( "\\w*"+s1+"\\w*" ) || s1.matches( "\\w*"+s2+"\\w*" );
	}
	
	public static void main(String[] args) {
		String s1 = "asd";
		String s2 = "sda";
		System.out.print(isRotation(s1, s2));
	}
}
