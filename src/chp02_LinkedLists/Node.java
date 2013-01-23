package chp02_LinkedLists;

public class Node {
	Node next = null;
	int data;
	
	public Node(int d) {
		data = d;
	}
	
	public Node(int[] data) {
		this.data = data[0];
		for(int i = 1; i < data.length; i++) {
			appendToTail(data[i]);
		}
	}
	
	void appendToTail(int d) {
		Node tail = new Node(d);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = tail;
	}
	
	Node deleteNode(Node head, int d) {
		Node n = head;
		if(n.data == d) {
			return head.next;
		}
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
	void print() {
		if(this == null) return;
		
		Node n = this;
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.print("\n");
	}
}