package tugas;

public class TicketQueue {
	Customer head;
	Customer tail;

	public TicketQueue() {
		this.head = null;
		this.tail = null;
	}

	public void addCustomer(String name, int ticketNumber) {
		Customer newCustomer = new Customer(name, ticketNumber);
		if (head == null) {
			head = tail = newCustomer;
		} else {
			tail.next = newCustomer;
			newCustomer.prev = tail;
			tail = newCustomer;
		}
	}

	public void removeCustomer(int ticketNumber) {
		if (head == null) {
			System.out.println("Antrian kosong.");
			return;
		}

		Customer current = head;

		while (current != null && current.ticketNumber != ticketNumber) {
			current = current.next;
		}
		if (current == null) {
			System.out.println("Tiket nomor " + ticketNumber + " tidak ditemukan.");
			return;
		}
		if (current == head) {
			head = current.next;
			if (head != null) {
				head.prev = null;
			} else {
				tail = null;
			}
		} else if (current == tail) {
			tail = current.prev;
			if (tail != null) {
				tail.next = null;
			}
		} else {
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}
	}

	public void displayQueue() {
		if (head == null) {
			System.out.println("Antrian kosong.");
			return;
		}

		Customer current = head;
		while (current != null) {
			System.out.println("Ticket #" + current.ticketNumber + " - " + current.name);
			current = current.next;
		}
	}
}