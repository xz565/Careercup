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
	
	/*
	 * reverse a String in Java
	 * time O(n) space O(1)
	 * actually the space is still n, because String in Java is immutable
	 */
	public static String reverse3(String str) {
		StringBuffer sb = new StringBuffer(str);
		int head = 0;
		int tail = sb.length() - 1;
		while(head < tail) {
			char tmp = sb.charAt(head);
			sb.setCharAt(head, sb.charAt(tail));
			sb.setCharAt(tail, tmp);
			
			head++;
			tail--;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "abcde 12345";
		System.out.println(reverse(str));
		System.out.println(reverse2(str.toCharArray()));
		System.out.println(reverse3(str));
	}
}
