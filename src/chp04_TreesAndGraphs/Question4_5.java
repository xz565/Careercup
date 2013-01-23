package chp04_TreesAndGraphs;

import java.util.ArrayList;

/*
 * Write an algorithm to find the ‘next’ node (i e , in-order successor) of 
 * a given node in a binary search tree where each node has a link to its parent
 */
public class Question4_5 {

	/* a simple method is to do an in-order traversal of the tree
	 * and find the next next element of current node*/
	public static TreeNode findNext(TreeNode node) {
		// first find the root
		TreeNode root = node;
		while(root.parent != null) {
			root = root.parent;
		}
		
		// in-order
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>(); 
		inOrder(root, nodes);
		
		int i = nodes.indexOf(node);
		return nodes.get(i + 1);
	}

	private static void inOrder(TreeNode root, ArrayList<TreeNode> nodes) {
		if(root.left != null) inOrder(root.left, nodes);
		nodes.add(root);
		if(root.right != null) inOrder(root.right, nodes);
	}
	
	// a more interesting one
	public static TreeNode findNext2(TreeNode node) {
		// if node has right child, return its left most child
		if(node.right != null) {
			TreeNode n = node.right;
			while(n.left != null) {
				n = n.left;
			}
			return n;
		} else { //
			TreeNode p = node.parent;
			while(p != null) {
				if(p.left == node) {
					break;
				}
				node = p;
				p = node.parent;
			}
			return p;
		}
	}
	
	public static void main(String[] args) {
		int[] nodes = {1, 3, 4, 7, 9, 11, 15, 28, 31};
		TreeNode root = Question4_3.buildBinaryTree(nodes, 0, nodes.length - 1);
		
		System.out.println(findNext(root));
		System.out.println(findNext(root.left.right.right));
		System.out.println(findNext(root.right));
		
		System.out.println(findNext2(root));
		System.out.println(findNext2(root.left.right.right));
		System.out.println(findNext2(root.right));
	}
}
