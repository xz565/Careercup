package chapter4;

public class Tree {
	TreeNode root;
	
	public Tree(int val) {
		root = new TreeNode(val);
	}
	
	public Tree(TreeNode n) {
		root = n;
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree(3);
		System.out.print(tree.root.left);
	}
}