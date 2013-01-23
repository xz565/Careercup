package chp02_LinkedLists;

/*
 * You have two numbers represented by a linked list, 
 * where each node contains a single digit
 * The digits are stored in reverse order,
 * such that the 1¡¯s digit is at the head of the list
 * 
 * Write a function that adds the two numbers
 * and returns the sum as a linked list
 * EXAMPLE
 * Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 */
public class Question2_4 {
	
	public static List add(List l1, List l2) {
		Node n1 = l1.head;
		Node n2 = l2.head;
		List sumList = new List();
		int carry = 0;
		int sum = 0;
		
		while(n1 != null && n2 != null) {
			int total = n1.data + n2.data + carry;
			sum = total % 10;
			carry = total / 10;
			sumList.appendToTail(sum);
			n1 = n1.next;
			n2 = n2.next;
		}
		
		while(n2 != null) {
				int total = carry + n2.data;
				sum = total % 10;
				carry = total / 10;
				sumList.appendToTail(sum);
				n2 = n2.next;
			}
		
		while(n1 != null) {
			int total = carry + n1.data;
			sum = total % 10;
			carry = total / 10;
			sumList.appendToTail(sum);
			n1 = n1.next;
		}
		
		if(carry == 1) {
			sumList.appendToTail(1);
		}
		
		return sumList;
	}
	
	/* recursive, much more interesting
	 * the code is much more concise */
	public static Node add2(Node n1, Node n2, int carry) {
		if(n1 == null && n2 == null && carry == 0) return null;
		
		int total = carry;
		if(n1 != null) {
			total += n1.data;
		}
		if(n2 != null) {
			total += n2.data;
		}

		Node result = new Node(total % 10);
		Node next = add2(n1 == null ? null : n1.next, n2 == null ? null : n2.next, total / 10);
		result.next = next;
		
		return result;
	}
	
	public static void main(String[] args) {
		List l1 = new List(new int[] {3, 1, 5});
		List l2 = new List(new int[] {5, 9, 2});
		List sum = add(l1, l2);
		Node sum2 = add2(l1.head, l2.head, 0);
		l1.print();
		l2.print();
		sum.print();
		sum2.print();
		
		System.out.print("\n");
		l1 = new List(new int[] {9, 9, 9, 9});
		l2 = new List(new int[] {1, 9, 2});
		sum = add(l1, l2);
		sum2 = add2(l1.head, l2.head, 0);
		l1.print();
		l2.print();
		sum.print();
		sum2.print();
		
		System.out.print("\n");
		l1 = new List(new int[] {});
		l2 = new List(new int[] {1, 9, 2});
		sum = add(l1, l2);
		sum2 = add2(l1.head, l2.head, 0);
		l1.print();
		l2.print();
		sum.print();
		sum2.print();
	}
}