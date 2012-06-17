package chapter4;

public class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		value = val;
		left = null;
		right = null;
	}
	
	public void addLeft(int val) {
		left = new TreeNode(val);
	}
	
	public void addLeft(TreeNode n) {
		left = n;
	}
	
	public void addRight(int val) {
		right = new TreeNode(val);
	}
	
	public void addRight(TreeNode n) {
		right = n;
	}
	public String toString() {
		return value + "";
	}
}
