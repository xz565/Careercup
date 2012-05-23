package chapter2;

/*
 * Write code to remove duplicates 
 * from an unsorted linked list 
 * FOLLOW UP
 * How would you solve this problem 
 * if a temporary buffer is not allowed?
 */
public class Question2_1 {

	/*
	 * a brute force algorithm
	 * time: O(n^2) space: O(1)
	 */
	public void removeDup(Node list) {
		if(list == null) return;
		
		Node currt = list;
		while(currt != null) {
			Node runner = currt;
			while(runner.next != null) {
				if(currt.data == runner.next.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			currt = currt.next;
		}
	}
	
	public static void main(String[] args) {
		Node list = new Node(0);
		list.appendToTail(0);
		list.appendToTail(0);
		
	}
}
