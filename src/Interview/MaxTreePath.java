package Interview;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, find the path with max_value.
 * Here a path starts from root and ends with bottom node.
 */
public class MaxTreePath {

	// This is a backward way
	static int findMaxPath(TreeNode root) {
		if(root == null)
			return 0;
		
		int leftMax = findMaxPath(root.left);
		int rightMax = findMaxPath(root.right);
		
		return leftMax > rightMax ? leftMax+root.value : rightMax+root.value;
	}
	
	// This is a forward way
	// Takes O(n) space, not good
	static int findMax(TreeNode root) {
		int sumSoFar = 0;
		List<Integer> maxVals = new ArrayList<Integer>();
		
		findMaxHelper(root, sumSoFar, maxVals);
		
		int max = 0;
		for(int val : maxVals) {
			if(val > max)
				max = val;
		}
		return max;
	}
	
	static void findMaxHelper(TreeNode root, int sumSoFar, List<Integer> maxVals) {
		if(root == null) {
			maxVals.add(sumSoFar);
			return;
		}
		
		findMaxHelper(root.left, sumSoFar + root.value, maxVals);
		findMaxHelper(root.right, sumSoFar + root.value, maxVals);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(7);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(5);
		TreeNode n7 = new TreeNode(1);
		TreeNode n8 = new TreeNode(10);
		
		n1.left = n2; n1.right = n3;
		
		n2.left = n4; n2.right = n5;
		
		n3.left = n6; n3.right = n7;
		
		n4.left = n8;
		
		System.out.println(findMaxPath(n1));
		System.out.println(findMax(n1));
	}
}

class TreeNode {
	int value;
	TreeNode left, right;
	
	TreeNode(int val) {
		value = val;
	}
}
