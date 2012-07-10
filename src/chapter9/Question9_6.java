package chapter9;

import java.util.HashSet;

/* Implement an algorithm to print all valid (e.g., properly 
 * opened and closed) combinations of n-pairs of parentheses.
 * 
 * EXAMPLE
 * Input 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class Question9_6 {

	static HashSet<String> printParentheses(int num) {
		HashSet<String> sets = new HashSet<String>();
		if(num == 0) return sets;
		
		if(num == 1) {
			sets.add("()");
			return sets;
		}
		
		HashSet<String> subSets = printParentheses(--num);
		for(String s : subSets) {
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(') {
					sets.add(insertAt(i, s));
				}
			}
			sets.add("()" + s);
		}
		return sets;
	}
	
	static String insertAt(int pos, String str) {
		String left = str.substring(0, pos);
		String right = str.substring(pos + 1);
		return left + "(()" + right;
	}
	
	public static void main(String[] args) {
		System.out.print(printParentheses(4));
	}
}
