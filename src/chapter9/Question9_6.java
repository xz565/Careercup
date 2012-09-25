package chapter9;

import java.util.HashSet;
import java.util.LinkedList;

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
	
	static void addParen(LinkedList<String> parens, int leftRem, int rightRem, char[] str, int pos) {
		if(leftRem < 0 || rightRem < leftRem) return;
		
		if(leftRem == 0 && rightRem == 0) {
			String s = String.copyValueOf(str);
			parens.add(s);
		}
		
		if(leftRem > 0) {
			str[pos] = '(';
			addParen(parens, leftRem - 1, rightRem, str, pos + 1);
		}
		
		if(rightRem > leftRem) {
			str[pos] = ')';
			addParen(parens, leftRem, rightRem - 1, str, pos + 1);
		}
	}
	
	public static void main(String[] args) {
		int num = 4;
		System.out.println(printParentheses(num));
		System.out.println(printParentheses(num).size());
		
		LinkedList<String> parens = new LinkedList<String>();
		char[] str = new char[num * 2];
		addParen(parens, num, num, str, 0);
		//for(String s : parens)
		//	System.out.println(s);
		System.out.println(parens);
		System.out.println(parens.size());	
	}
}
