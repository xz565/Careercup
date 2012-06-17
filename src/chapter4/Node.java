package chapter4;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int val) {
		value = val;
		left = null;
		right = null;
	}
	
	public void addLeft(int val) {
		left = new Node(val);
	}
	
	public void addLeft(Node n) {
		left = n;
	}
	
	public void addRight(int val) {
		right = new Node(val);
	}
	
	public void addRight(Node n) {
		right = n;
	}
	public String toString() {
		return value + "";
	}
}
