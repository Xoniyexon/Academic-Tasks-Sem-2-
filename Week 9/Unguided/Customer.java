package tugas;

public class Customer {
	String name;
	int ticketNumber;
	Customer prev;
	Customer next;

	public Customer(String name, int ticketNumber) {
		this.name = name;
		this.ticketNumber = ticketNumber;
		this.prev = null;
		this.next = null;
	}
}
