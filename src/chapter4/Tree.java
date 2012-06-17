package chapter4;

public class Tree {
	Node root;
	
	public Tree(int val) {
		root = new Node(val);
	}
	
	public Tree(Node n) {
		root = n;
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree(3);
		System.out.print(tree.root.left);
	}
}