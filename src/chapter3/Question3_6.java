package chapter3;

import java.util.Stack;

/*
 * Write a program to sort a stack in ascending order 
 * 
 * You should not make any assumptions about how the stack is implemented   
 * 
 * The following are the only functions that should be 
 * used to write this program: push | pop | peek | isEmpty
 */
public class Question3_6 {

	/*
	 * a brute force method
	 * time: O(n^2) space: 3n
	 */
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> out = new Stack<Integer>();
		Stack<Integer> buffer = new Stack<Integer>();
		while(!stack.isEmpty()) {
			int min = Integer.MAX_VALUE;
			while(!stack.isEmpty()) {
				int temp = stack.pop();
				min = Math.min(min, temp);
				buffer.push(temp);
			}
			while(!buffer.isEmpty()){
				int temp = buffer.pop();
				if(temp == min) {
					out.push(temp);
				} else {
					stack.push(temp);
				}
			}
		}
		return out;
	}
	
	/*
	 * a slightly better one
	 * time: O(n^2) space: 2n
	 */
	public static Stack<Integer> sortStack2(Stack<Integer> stack) {
		Stack<Integer> out = new Stack<Integer>();
		out.push(stack.pop());
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			int temp2 = out.peek();
			while(temp > temp2 && !out.isEmpty()) {
				temp2 = out.pop();
				stack.push(temp2);
				if(!out.isEmpty()) {
					temp2 = out.peek();
				}
			}
			out.push(temp);
		}
		return out;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		stack.push(2);
		stack.push(4);
		stack.push(8);
		stack.push(3);
		stack.push(10);
		stack.push(3);
		System.out.println(stack);
		Stack<Integer> out = sortStack2(stack);
		System.out.println(out);
	}
}
