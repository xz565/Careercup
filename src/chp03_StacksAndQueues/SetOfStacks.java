package chp03_StacksAndQueues;

import java.util.ArrayList;

/*
 * Imagine a (literal) stack of plates. If the stack 
 * gets too high, it might topple.   
 * Therefore, in real life, we would likely start a new 
 * stack when the previous stack exceeds some threshold. 
 * 
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of several stacks, and 
 * should create a new stack once the previous one exceeds 
 * capacity. SetOfStacks push() and SetOfStacks pop() should 
 * behave identically to a single stack (that is, pop() should 
 * return the same values as it would if there were just a single stack) 
 * 
 * FOLLOW UP
 * Implement a function popAt(int index) which performs 
 * a pop operation on a specific sub-stack
 */
public class SetOfStacks {
	ArrayList<MyStack> stacks;
	public static final int MAX_SIZE = 3;
	
	public SetOfStacks() {
		stacks = new ArrayList<MyStack>();
	}
	
	public void push(Node item) {
		MyStack lastStack = getLast();
		
		if(lastStack != null && lastStack.size() != MAX_SIZE) {
			lastStack.push(item);
		} else {
			MyStack newStack = new MyStack();
			newStack.push(item);
			stacks.add(newStack);
		}
		
	}

	private MyStack getLast() {
		int size = stacks.size();
		if(size == 0) return null;
		return stacks.get(size - 1);
	}

	public Node pop() {
		MyStack lastStack = getLast();
		Node n = lastStack.pop();
		if(lastStack.size() == 0) {
			stacks.remove(lastStack);
		}
		return n;
	}
	
	public void print() {
		for(MyStack myS : stacks) {
			myS.print();
		}
		System.out.println("size: " + stacks.size());
	}
	
	public static void main(String[] args) {
		SetOfStacks ss = new SetOfStacks();
		ss.print();
		ss.push(new Node(1));
		ss.push(new Node(2));
		ss.push(new Node(3));
		ss.push(new Node(4));
		ss.push(new Node(5));
		ss.push(new Node(6));
		ss.push(new Node(7));
		ss.print();
		ss.pop();
		ss.pop();
		ss.pop();
		ss.print();
	}
}
