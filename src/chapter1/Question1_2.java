package chapter1;

import java.util.Stack;

/*
 * write code to reverse a C-Style String. 
 * (C-String means that "abcd" is represented 
 * as five characters, including the null character.)
 */
public class Question1_2 {

	/* a naive one by using a stack 
	 * time: O(n) space O(n) */
	public static String reverse(String str) {
		Stack<Character> stack = new Stack<Character>();
		for(char c : str.toCharArray()) {
			stack.push(c);
		}
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	
	/* a better one works in place 
	 * time: O(n) space: O(1)*/
	public static char[] reverse2(char[] str) {
		int len = str.length;
		for(int i = 0; i < len / 2; ++i) {
			char head = str[i];
			str[i] = str[len - 1 - i];
			str[len - 1 - i] = head;
		}
		return str;
	}
	
	public static void main(String[] args) {
		String str = "abcde 12345";
		System.out.println(reverse(str));
		System.out.println(reverse2(str.toCharArray()));
	}
}
