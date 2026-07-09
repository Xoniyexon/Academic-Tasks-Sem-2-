package tugas;

public class Gallery {
	Node head;
	Node current;

	static class Node {
		ArtPiece data;
		Node next;

		Node(ArtPiece art) {
			data = art;
			next = null;
		}
	}

	public Gallery() {
		this.head = null;
		this.current = null;
	}

	public void addPiece(ArtPiece piece) {
		Node newNode = new Node(piece);

		if (head == null) {
			head = newNode;
			newNode.next = head;
			current = head;
		} else {
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = head;
		}
		System.out.println("Piece added to the gallery!");
	}

	public void deletePiece(String name) {
		if (head == null) {
			System.out.println("Gallery is Empty!");
			return;
		}

		Node currNode = head;
		Node prevNode = null;

		if (currNode.data.getName().equals(name)) {
			if (currNode.next == head) {
				head = null;
				current = null;
				System.out.println("Piece removed!");
				return;
			}

			Node lastNode = head;
			while (lastNode.next != head) {
				lastNode = lastNode.next;
			}
			head = currNode.next;
			lastNode.next = head;
			current = head;
			System.out.println("Piece removed!");
			return;
		}

		do {
			prevNode = currNode;
			currNode = currNode.next;

			if (currNode.data.getName().equals(name)) {
				prevNode.next = currNode.next;
				if (current == currNode) {
					current = prevNode.next;
				}
				System.out.println("Piece removed!");
				return;
			}
		} while (currNode != head);

		System.out.println("Art piece not found!");
	}

	public void nextArt() {
		if (head == null) {
			System.out.println("Gallery is Empty! Add an art piece!");
		} else {
			System.out.println("Art Piece: " + current.data.describePiece());
			current = current.next;
		}
	}
}