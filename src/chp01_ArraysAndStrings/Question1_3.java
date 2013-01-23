package chp01_ArraysAndStrings;

/* Design an algorithm and write code to remove the duplicate characters in a string 
 * without using any additional buffer
 * NOTE: One or two additional variables are fine
 * An extra copy of the array is not allowed 
 * FOLLOW UP
 * Write the test cases for this method
 */
public class Question1_3 {

	/* time: O(n^2) space: O(1) */
	public static StringBuffer removeDup(StringBuffer str) {
		for(int i = 0; i < str.length(); i++) {
			for(int j = i + 1; j < str.length(); j++) {
				if(str.charAt(j) == str.charAt(i)) {
					str.deleteCharAt(j--);
				}
			}
		}
		return str;
	}
	
	/* it's easy for this question if using StrigBuffer as above
	 * it's a little trickier if using only array
	 */
	/* time: O(n^2) space: O(1)*/
	public static char[] removeDup2(char[] str) {
		int tail = 1;
		for(int i = 0; i < str.length; i++) {
			int j;
			for(j = 0; j < tail; j++) {
				if(str[i] == str[j]) break;
			}
			if(j == tail) {
				str[tail++] = str[i];
			}
		}
		for(int i = tail; i < str.length; i++)
			str[i] = 0;
		return str;
	}
	
	public static void main(String[] args) {
		String[] strs = {"aaaaaaaaaaaaaaa", "asdfghjkl", "abcabca", "", "asdafghjkl"};
		for(String str : strs)
			System.out.println(removeDup(new StringBuffer(str)));
		System.out.println();
		for(String str : strs)
			System.out.println(removeDup2(str.toCharArray()));
	}
}