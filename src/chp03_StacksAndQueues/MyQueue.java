package chp03_StacksAndQueues;

import java.util.Stack;

/*
 * Implement a MyQueue class which implements a queue using two stacks
 */
public class MyQueue {

	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public MyQueue() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void enqueue(int item) {
		stack1.push(item);
	}
	
	public int dequeue() {
		// if s2 is not empty, use elements in s2
		if(!stack2.isEmpty()) {
			return stack2.pop();
		}
		// if s2 is empty, reverse elements in s1 into s2
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	
	public int peek() {
		if(!stack2.isEmpty()) return stack2.peek();
		while(!stack1.isEmpty()) stack2.push(stack1.pop());
		return stack2.peek();
	}
	
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	public int size() {
		return stack1.size() + stack2.size();
	}
}
