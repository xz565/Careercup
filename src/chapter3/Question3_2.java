package chapter3;

/*
 * How would you design a stack which, in addition to push and pop, 
 * also has a function min which returns the minimum element? 
 * Push, pop and min should all operate in O(1) time
 */

/*
 * one simple way to solve this question is to keep 
 * a field minNode in the class, when push in a new Node, 
 * compare the value of the node with that of minNode.
 * 
 * There is one issue with this, if the minNode is pop out,
 * we should travel through the whole stack to find the new minNode,
 * this takes O(n) time.
 * So the worst time for pop is O(n), but the amortized time may still
 * be O(1). is this right?
 */
public class Question3_2 extends MyStack{
	
	public void push(Node n) {
		super.push(n);
		
		if(n.next == null || n.value < n.next.min.value) {
			n.min = n;
		} else {
			n.min = n.next.min;
		}
	}
	
	public Node min() {
		return top.min;
	}
	
	public static void main(String[] args) {
		Question3_2 stack = new Question3_2();
		stack.push(new Node(3));
		stack.push(new Node(5));
		stack.push(new Node(7));
		stack.push(new Node(1));
		stack.push(new Node(2));
		stack.print();
		System.out.print("min: " + stack.min().value);
	}
}