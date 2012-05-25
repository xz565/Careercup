package chapter2;

/*
 * Implement an algorithm to delete a node in 
 * the middle of a single linked list, given 
 * only access to that node 
 * EXAMPLE
 * Input: the node ¡®c¡¯ from the linked list a->b->c->d->e
 * Result: nothing is returned, 
 * but the new linked list looks like a->b->d->e
 */
public class Question2_3 {

	/* if mid is the last node of the list
	 * the method will fail */
	public static boolean removeMiddle(Node mid) {
		if(mid == null || mid.next == null) return false;
		mid.data = mid.next.data;
		mid.next = mid.next.next;
		return true;
	}
	
	public static void main(String[] args) {
		List list = new List(new int[] {1, 2, 3, 4, 5});
		Node mid = list.head;
		mid = mid.next.next;
		list.print();
		mid.print();
		removeMiddle(mid);
		list.print();
	}
}
