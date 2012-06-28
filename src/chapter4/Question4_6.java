package chapter4;

/*
 * Design an algorithm and write code to find the first 
 * common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure
 * NOTE: This is not necessarily a binary search tree
 */
public class Question4_6 {
	
	/* Learned a lot about recursive by writing this code */
	public static TreeNode findAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
		if(root == null) return null;
		
		TreeNode left = findAncestor(root.left, n1, n2);
		if(left != null) return left;
		
		TreeNode right = findAncestor(root.right, n1, n2);
		if(right != null) return right;

		int countLeft  = countAnc(root.left, n1, n2);
		int countRight  = countAnc(root.right, n1, n2);
		if(countLeft + countRight == 2) return root;
		
		return null;
	}
	
	public static int countAnc(TreeNode root, TreeNode n1, TreeNode n2) {
		if(root == null) return 0;
		int count = 0;
		count += countAnc(root.left, n1, n2);
		count += countAnc(root.right, n1, n2);
		if(root == n1) count++;
		if(root == n2) count++;
		return count;
	}
	
	public static void main(String[] args) {
		int[] nodes = {1, 3, 4, 7, 9, 11, 15, 28, 31};
		TreeNode root = Question4_3.buildBinaryTree(nodes, 0, nodes.length - 1);
		
		TreeNode ancestor = findAncestor(root, root, root.left);
		System.out.println(ancestor);
		
		ancestor = findAncestor(root, root.left, root.right);
		System.out.println(ancestor);
		
		ancestor = findAncestor(root, root.left, root.left.left);
		System.out.println(ancestor);
		
		ancestor = findAncestor(root, root.left.left, root.left.right);
		System.out.println(ancestor);
	}
}