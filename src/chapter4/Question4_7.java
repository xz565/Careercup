package chapter4;

/* You have two very large binary trees: T1, with millions of nodes, 
 * and T2, with hundreds of nodes
 * Create an algorithm to decide if T2 is a subtree of T1
 */
public class Question4_7 {

	// a simple way is for each node n in T1, 
	// check whether T2 is subTree of n rooted in n,
	// complex for this method is bad
	public static boolean isSubtree(TreeNode T1, TreeNode T2) {
		// base cases
		if(T2 == null) return true;
		if(T1 == null && T2 != null) return false;

		// pre-order search
		if(isSubHelper(T1, T2)) return true;
		if(isSubtree(T1.left, T2)) return true;
		if(isSubtree(T1.right, T2)) return true;
		
		return false;
	}
	
	static boolean isSubHelper(TreeNode T1, TreeNode T2) {
		if(T2 == null) return true;
		
		if(T1.value != T2.value) return false;
		if(!isSubHelper(T1.left, T2.left)) return false;
		if(!isSubHelper(T1.right, T2.right)) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] nodes = {1, 3, 4, 7, 9, 11, 15, 28, 31};
		TreeNode T1 = Question4_3.buildBinaryTree(nodes, 0, nodes.length - 1);
		
		TreeNode T2 = new TreeNode(15);
		T2.addLeft(11);
		T2.addRight(28);
		System.out.println(isSubtree(T1, T2));
	}
}
