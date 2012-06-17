package chapter4;

/*
 * Implement a function to check if a tree is balanced
 * 
 * For the purposes of this question, a balanced tree is 
 * defined to be a tree such that no two leaf nodes differ 
 * in distance from the root by more than one
 */
public class Question4_1 {

	public static boolean isBalanced(TreeNode root) {
		int max = maxHeight(root);
		int min = minHeight(root);
		System.out.println("max: " + max + " min " + min);
		return (max - min) <= 1;
	}

	private static int minHeight(TreeNode node) {
		if(node == null) return 0;
		if(node.left == null && node.right == null) return 0;
		return 1 + Math.min(minHeight(node.left), minHeight(node.right));
	}

	private static int maxHeight(TreeNode node) {
		if(node == null) return 0;
		if(node.left == null && node.right == null) return 0;
		return 1 + Math.max(maxHeight(node.left), maxHeight(node.right));
	}

	public static void main(String[] args) {
		Tree tree = new Tree(8);
		tree.root.addLeft(10);
		tree.root.addRight(12);
		TreeNode n1 = tree.root.left;
		TreeNode n2 = tree.root.right;
		n1.addLeft(20);
		n1.addRight(22);
		n1.left.addLeft(15);
		System.out.println(isBalanced(tree.root));
		n2.addRight(17);
		System.out.print(isBalanced(tree.root));
	}
}
