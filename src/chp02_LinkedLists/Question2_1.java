package chp02_LinkedLists;

import java.util.HashSet;

/*
 * Write code to remove duplicates 
 * from an unsorted linked list 
 * FOLLOW UP
 * How would you solve this problem 
 * if a temporary buffer is not allowed?
 */
public class Question2_1 {

	/* a brute force algorithm
	 * time: O(n^2) space: O(1)
	 */
	public static void removeDup(Node list) {
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
	
	/* method with additional buffer 
	 * time: O(n) space: O(n)*/
	public static void rmDup(Node list) {
		if(list == null) return;
		
		HashSet<Integer> eleSet = new HashSet<Integer>();
		Node prev = list;
		Node currt = list.next;
		eleSet.add(prev.data);
		while(currt != null) {
			if(eleSet.contains(currt.data)) {
				prev.next = currt.next;
			} else {
				eleSet.add(currt.data);
				prev = prev.next;
			}
			currt = currt.next;
		}
	}
	
	public static void main(String[] args) {
		Node list = new Node(new int[] {0, 0, 0, 1, 2, 1});
		list.print();
		//removeDup(list);
		rmDup(list);
		list.print();
	}
}