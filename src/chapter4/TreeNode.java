package chapter4;

public class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	public TreeNode(int val) {
		value = val;
		left = null;
		right = null;
		parent = null;
	}
	
	public void addLeft(int val) {
		addLeft(new TreeNode(val));
	}
	
	public void addLeft(TreeNode n) {
		if(n == null) return;
		this.left = n;
		n.parent = this;
	}
	
	public void addRight(int val) {
		addRight(new TreeNode(val));
	}
	
	public void addRight(TreeNode n) {
		if(n == null) return;
		this.right = n;
		n.parent = this;
	}
	public String toString() {
		return value + "";
	}
}
