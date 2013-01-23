package chp03_StacksAndQueues;

public class MyStack {
	Node top = null;
	
	public void push(Node n) {
		n.next = top;
		top = n;
	}
	
	public Node pop() {
		if(top != null) {
			Node n = top;;
			top = top.next;
			return n;
		}
		return null;
	}
	
	public Node peek() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		if(top != null) {
			int count = 0;
			Node n = top;
			while(n != null) {
				count++;
				n = n.next;
			}
			return count;
		}
		return 0;
	}
	
	public void print() {
		Node n = top;
		while(n != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		System.out.println(stack.isEmpty());
		stack.push(new Node(1));
		stack.push(new Node(3));
		stack.pop();
		stack.push(new Node(7));
		stack.print();
		stack.pop();
		System.out.println(stack.isEmpty());
		stack.pop();
		stack.pop();
		System.out.print("size:" + stack.size());
		
	}
}

class Node {
	int value;
	Node next = null;
	Node min = null;
	
	public Node(int n) {
		value = n;
	}
}