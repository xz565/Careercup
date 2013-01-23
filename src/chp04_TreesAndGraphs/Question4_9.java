package chp04_TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/* You are given a binary tree in which each node contains a value
 * Design an algorithm to print all paths which sum up to that value
 * Note that it can be any path in the tree, 
 * it does not have to start at the root
 */
public class Question4_9 {

	// a workable algorithm with only positive intergers in the tree
	static void findSumPaths(TreeNode root, int sum, List<List<TreeNode>> paths) {
		if(root == null) return;
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		findPathsForOneNode(root, sum, path, paths);
		
		findSumPaths(root.left, sum, paths);
		findSumPaths(root.right, sum, paths);
	}
	
	@SuppressWarnings("unchecked")
	static void findPathsForOneNode(TreeNode root, 
			int sum, ArrayList<TreeNode> path, List<List<TreeNode>> paths) {
		if(root == null) return;
		
		path.add(root);
		
		if(sumPath(path) > sum) {
			return;
		}
		else if(sumPath(path) == sum) {
			paths.add(path);
			return;
		} else {
			ArrayList<TreeNode> p1 = (ArrayList<TreeNode>)path.clone();
			ArrayList<TreeNode> p2 = (ArrayList<TreeNode>)path.clone();
			
			findPathsForOneNode(root.left, sum, p1, paths);
			findPathsForOneNode(root.right, sum, p2, paths);
		}
	}
	
	static int sumPath(List<TreeNode> path) {
		int sum = 0;
		for(TreeNode node : path) {
			sum += node.value;
		}
		return sum;
	}
	
	/*
	static void findSum(TreeNode root, int sum, ArrayList<Integer> buffer, int level) {
		if(root == null) return;
		int tmp = sum;
		buffer.add(root.value);
		for(int i = level; i > -1; i--) {
			tmp -= buffer.get(i);
			if(tmp ==0) print(buffer, i, level);
		}
		
		ArrayList<Integer> b1 = (ArrayList<Integer>)buffer.clone();
		ArrayList<Integer> b2 = (ArrayList<Integer>)buffer.clone();
		findSum(root.left, sum, b1, level + 1);
		findSum(root.left, sum, b2, level + 1);
	}
	
	static void print(ArrayList<Integer> buffer, int level, int i2) {
		for(int i = level; i < i2; i++) {
			System.out.print(buffer.get(i) + " ");
		}
		System.out.println();
	}
	*/
	
	public static void main(String[] args) {
		int[] nodes = {1, 3, 4, 7, 9, 11, 4, 3, -3};
		TreeNode root = Question4_3.buildBinaryTree(nodes, 0, nodes.length - 1);
		
		List<List<TreeNode>> paths = new ArrayList<List<TreeNode>>();
		findSumPaths(root, 13, paths);
		System.out.print(paths);
	}
}
