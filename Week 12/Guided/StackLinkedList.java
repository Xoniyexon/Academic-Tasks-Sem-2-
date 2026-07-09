package tugas;

public class StackLinkedList<T> {
	private class Node{
		T data;
		Node next;
		
		Node(T data){
			this.data = data;
			this.next = null;
			}
	}
	
	private Node top;
	
	public StackLinkedList() {
		this.top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}

	public void push (T data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}
	
	public T pop() {
		if (isEmpty()) {
			System.out.println("Stack underflow!");
			return null;
		}
		T poppedValue = top.data;
		top = top.next;
		return poppedValue;
	}
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return null;
		}
		return top.data;
	}
	
	public void printStack() {
		Node temp = top;
		System.out.println("[ ");
		while (temp!= null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("]");
	}
}
