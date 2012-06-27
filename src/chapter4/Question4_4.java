package chapter4;

import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary search tree, design an algorithm which 
 * creates a linked list of all the nodes at each depth 
 * (i e , if you have a tree with depth D, you’ll have D linked lists)
 */
public class Question4_4 {

	public static List<List<TreeNode>> getEachLevel(TreeNode root) {
		List<List<TreeNode>> levelNodes = new LinkedList<List<TreeNode>>();
		List<TreeNode> level = new LinkedList<TreeNode>();
		level.add(root);
		levelNodes.add(level);
		while(true) {
			level = levelNodes.get(levelNodes.size() - 1);
			List<TreeNode> newLevel = new LinkedList<TreeNode>();
			for(TreeNode n : level) {
				if(n.left != null) newLevel.add(n.left);
				if(n.right != null) newLevel.add(n.right);
			}
			if(newLevel.isEmpty()) break;
			levelNodes.add(newLevel);
		}
		return levelNodes;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		
		root.addLeft(10);
		root.addRight(12);
		
		root.left.addLeft(20);
		root.left.addRight(22);
		root.right.addRight(17);
		
		List<List<TreeNode>> levelNodes = getEachLevel(root);
		System.out.println(levelNodes);
	}
}
