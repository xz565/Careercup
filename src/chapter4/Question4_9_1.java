package chapter4;

import java.util.HashMap;
import java.util.List;

public class Question4_9_1 {
	static HashMap<TreeNode, TreeNode> parentTable = new HashMap<TreeNode, TreeNode>();
	static HashMap<TreeNode, TreeNode> resultPaths = new HashMap<TreeNode, TreeNode>();
	static int N = 13;
	
	public void getSumPath(TreeNode root) {
		if(root == null) return;
		
		if(parentTable.isEmpty()) 
			parentTable.put(root, null);
		
		possiblePaths(root);
		
		if(root.left != null) parentTable.put(root.left, root);
		getSumPath(root.left);
		
		if(root.right != null)  parentTable.put(root.right, root);
		getSumPath(root.right);
	}
	
	public void possiblePaths(TreeNode leaf) {
		TreeNode currt = leaf;
		int sum = 0;
		while(currt != null) {
			sum += currt.value;
			if(sum == N) 
				resultPaths.put(leaf, currt);
			currt = parentTable.get(currt);
		}
	}
	
	public void print() {
		for (TreeNode n : resultPaths.keySet()) {
			TreeNode endNode = resultPaths.get(n);
			TreeNode currt = n;
			System.out.print(currt + " ");
			while(currt.value != endNode.value) {
				currt = parentTable.get(currt);
				System.out.print(currt + " ");
			}
			System.out.println();
		}
		
		//System.out.println(parentTable);
		//System.out.println(resultPaths);
	}
	
	public static void main(String[] args) {
		int[] nodes = {1, 3, 4, 7, 9, 11, 4, 3, -3};
		TreeNode root = Question4_3.buildBinaryTree(nodes, 0, nodes.length - 1);
		
		List<List<TreeNode>> levelNodes = Question4_4.getEachLevel(root);
		System.out.println(levelNodes);
		
		Question4_9_1 q = new Question4_9_1();
		q.getSumPath(root);
		q.print();
	}
}