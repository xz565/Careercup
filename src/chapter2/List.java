package chapter2;

public class List {
	
	Node head;
	
	public List() {}

	public List(Node h) {
		head = h;
	}
	
	public List(int[] data) {
		if(data.length > 0) {
			head = new Node(data[0]);
			for(int i = 1; i < data.length; i++) {
				head.appendToTail(data[i]);
			}
		} else {
			head = null;
		}
	}
	
	public int length() {
		int len = 0;
		Node n = head;
		while(n != null) {
			n = n.next;
			len++;
		}
		return len;
	}
	
	public void appendToTail(Node n) {
		if(head == null) {
			head = n;
		} else {
			head.appendToTail(n.data);
		}
	}
	
	public void appendToTail(int d) {
		if(head == null) {
			head = new Node(d);
		} else {
			head.appendToTail(d);
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("null");
		} else {
			head.print();
		}
	}
}
