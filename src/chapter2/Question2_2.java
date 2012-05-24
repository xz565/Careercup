package chapter2;

/* 
 * Implement an algorithm to find the nth 
 * to last element of a singly linked list
 */
public class Question2_2 {

	public static Node findNth(List list, int n) {
		if(list.length() < n) return null;
		
		Node front = list.head;
		Node end = list.head;;
		for(int i = 0; i < n; i++) {
			end = end.next;
		}
		while(end != null) {
			front = front.next;
			end = end.next;
		}
		return front;
	}
	
	public static void main(String[] args) {
		List list = new List(new int[] {0, 0, 0, 1, 2, 3, 4, 5, 6, 7});
		list.print();
		Node nth = findNth(list, 6);
		nth.print();
	}
}
