package chapter4;

/*
 * Given a sorted (increasing order) array, write an 
 * algorithm to create a binary tree with minimal height
 */
public class Question4_3 {

	public static TreeNode buildBinaryTree(int[] arr, int start, int end) {
		if(start > end) return null;
		
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.addLeft(buildBinaryTree(arr, start, mid - 1));
		root.addRight(buildBinaryTree(arr, mid + 1, end));
		return root;
	}
}
