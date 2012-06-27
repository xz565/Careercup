package chapter4;

import java.util.List;

/*
 * Given a sorted (increasing order) array, write an 
 * algorithm to create a binary tree with minimal height
 */
public class Question4_3 {

	/* recursive */
	public static TreeNode buildBinaryTree(int[] arr, int start, int end) {
		if(start > end) return null;
		
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.addLeft(buildBinaryTree(arr, start, mid - 1));
		root.addRight(buildBinaryTree(arr, mid + 1, end));
		return root;
	}
	
	/* using method in Q4.4, it's easy to see the result */
	public static void main(String[] args) {
		int[] nodes = {1, 3, 4, 7, 9, 11, 15, 28, 31};
		TreeNode root = Question4_3.buildBinaryTree(nodes, 0, nodes.length - 1);
		
		List<List<TreeNode>> levelNodes = Question4_4.getEachLevel(root);
		System.out.println(levelNodes);
	}
}
