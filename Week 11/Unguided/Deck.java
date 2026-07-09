package tugas;

public class Deck {
	Node head;
	Node current = head;

	static class Node {
		Card data;
		Node next;
		Node prev;

		Node (Card card){
			data = card; 
			next = null;
			prev = null;
		}
	}

	public void addCard(Card card) {
		Node newNode = new Node(card);
		
		if (head == null) {
			head = newNode;
			head.next = head;
			head.prev = head;
			current = head;
		} else {
			Node last = head.prev;
			last.next = newNode;
			newNode.prev = last;
			newNode.next = head;
			head.prev = newNode;
		}
		System.out.println("Card Added!");
	}
	
	public void removeCard(String type, String value) {
		if(head == null) {
			return;
		}
		
		Node temp = head;
		boolean found = false;
		
		do {
			if (temp.data.getType().equals(type) && temp.data.getValue().equals(value)) {
				found = true;
				break;
			}
			temp = temp.next;
		} while (temp != head);
		
		if(found) {
			if (head.next == head) {
				head = null;
				current = null;
			} else {
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				
				if (temp == head) {
					head = temp.next;
				}
				
				if (current == temp) {
					current = head;
				}
			}
			System.out.println("Card Removed!");
		} else {
			System.out.println("Card not found.");
		}
	}
	
	public void moveNext() {
		if (head == null) {
			System.out.println("Deck is empty!");
			return;
		}
		
		current = current.next;
		
		System.out.println(current.data.toString());
	}
	
	public void movePrev() {
		if (head == null) {
			System.out.println("Deck is empty!");
			return;
		}
		
		current = current.prev;
		
		System.out.println(current.data.toString());
	}
}
