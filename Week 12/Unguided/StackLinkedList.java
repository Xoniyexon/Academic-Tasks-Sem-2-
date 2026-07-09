package tugas;

public class StackLinkedList<T> {
	private Node<T> top;

	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next = top;
		top = newNode;
	}

	public T pop() {
		if (isEmpty()) {
			System.out.println("Stack kosong, tidak ada buku yang bisa dipinjam.");
			return null;
		}
		T data = top.data;
		top = top.next;
		return data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Tidak ada buku di perpustakaan.");
			return;
		}
		Node<T> current = top;
		while (current != null) {
			System.out.println(current.data.toString());
			current = current.next; 
		}
	}
}
