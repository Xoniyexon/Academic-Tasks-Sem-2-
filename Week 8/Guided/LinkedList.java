package tugas;

public class LinkedList<T> {
	private Node<T> head;
	
	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void append(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	public void deleteNode(T key) {
		if (head == null) return;
		
		if (head.data.equals(key)) {
			head = head.next;
			return;
		}
		
		Node<T> temp = head, prev = null;
		while (temp != null && !temp.data.equals(key)) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null) return;
		
		prev.next = temp.next;
		}

	public boolean search(T key) {
		Node<T> temp = head;
		while (temp != null) {
			if (temp.data.equals(key)) return true;
			temp = temp.next;
		}
		return false;
	}
	
	public void display() {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node<T> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
}
