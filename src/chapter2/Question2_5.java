package chapter2;

/*
 * Given a circular linked list, implement an algorithm 
 * which returns node at the beginning of the loop 
 * DEFINITION 
 * Circular linked list: A (corrupt) linked list in which a node¡¯s next pointer 
 * points to an earlier node, so as to make a loop in the linked list 
 * EXAMPLE
 * input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * output: C
 */
public class Question2_5 {

	/* a very tricky solution */
	public static Node findLoop(Node head) {
		Node fastRunner = head.next.next;
		Node slowRunner = head.next;
		
		while(fastRunner != slowRunner && fastRunner != null && slowRunner != null) {
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
		}
		slowRunner = head;
		while(slowRunner != fastRunner) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}
		return fastRunner;
	}
	
	public static void main(String[] args) {
		/* 1 -> 2 -> 3 -> 4 ->5 -> 3 */
		Node n1 = new Node(new int[] {1, 2, 3, 4, 5});
		Node n3 = n1.next.next;
		Node n5 = n3.next.next;
		n5.next = n3;
		//n1.print();
		Node loopStart = findLoop(n1);
		System.out.print(loopStart.data);
	}
}
