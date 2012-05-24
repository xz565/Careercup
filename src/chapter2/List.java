package chapter2;

public class List {
	
	Node head;

	public List(int[] data) {
		head = new Node(data[0]);
		for(int i = 1; i < data.length; i++) {
			head.appendToTail(data[i]);
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
	
	public void  print() {
		this.head.print();
	}
}
