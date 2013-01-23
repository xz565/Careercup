package chp01_ArraysAndStrings;

/*
 * Write a method to replace all spaces in a string with ‘%20’
 */
public class Question1_5 {

	/* using traditional style of string:
	 * an array of chars like in C/C++
	 * time: O(n) space O(n)
	 */
	public static String replaceSpace(String str) {
		char[] charStr = str.toCharArray();
		int spaceCount = 0;
		int length = charStr.length;
		for(int i = 0; i < length; i++) {
			if(charStr[i] == ' ') spaceCount++;
		}
		char[] newStr = new char[length + spaceCount * 2];
		int j = 0;
		for(int i = 0; i < length; i++) {
			if(charStr[i] == ' ') {
				newStr[j] = '%';
				newStr[j + 1] = '2';
				newStr[j + 2] = '0';
				j += 3;
			} else {
				newStr[j] = charStr[i];
				j++;
			}
		}
		return new String(newStr);
	}
	
	/* with the help of API in Java,
	 * the code is much more concise*/
	public static String replaceSpace2(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);
			if(ch == ' ') {
				sb.append("%20");
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(replaceSpace(""));
		System.out.println(replaceSpace(" "));
		System.out.println(replaceSpace("    "));
		System.out.println(replaceSpace(" a s d f g h j k l "));
		System.out.println(replaceSpace("asdfghjkl"));

		System.out.println(replaceSpace2(""));
		System.out.println(replaceSpace2(" "));
		System.out.println(replaceSpace2("    "));
		System.out.println(replaceSpace2(" a s d f g h j k l "));
		System.out.println(replaceSpace2("asdfghjkl"));
	}
}
