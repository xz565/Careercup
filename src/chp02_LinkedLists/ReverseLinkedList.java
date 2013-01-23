package chp02_LinkedLists;

public class ReverseLinkedList {
	public static MyNode reverse(MyNode head) {
		if(head == null) return null;
		if(head.next == null) return head;
					
		MyNode currt = head;
		MyNode next = currt.next;
		MyNode previous = null;
		
		while(next != null) {
			previous = currt;
			currt = next;
			next = currt.next;
			currt.next = previous;
		}
		
		head.next = null;
		head = currt;
		return head;
	}
	
	public static void main(String[] args) {
		MyNode head = new MyNode(0);
		head.appendToTail(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.print();
		
		head = reverse(head);
		head.print();
	}
}

class MyNode {
	int value;
	MyNode next = null;
	
	public MyNode(int val) {
		this.value = val;
	}
	
	public void appendToTail(int val) {
		MyNode n = this;
		while(n.next != null)
			n = n.next;
		n.next = new MyNode(val);
	}
	
	public void print() {
		MyNode n = this;
		while(n != null) {
			System.out.print(n.value + "->");
			n = n.next;
		}
		System.out.println("null");
	}
}
