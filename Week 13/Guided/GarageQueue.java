package tugas;

public class GarageQueue {
	private Node front, rear;
	private int queueCounter;

	static class Node {
		Customer customer;
		Node next;

		Node(Customer customer) {
			this.customer = customer;
			this.next = null;
		}
	}

	public GarageQueue() {
		this.front = this.rear = null;
		this.queueCounter = 1;
	}

	public void enqueue(String name, String motorType) {
		Customer newCustomer = new Customer(queueCounter++, name, motorType);
		Node newNode = new Node(newCustomer);

		if (rear == null) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		System.out.println("Pelanggan " + name + " berhasil ditambahkan ke antrian.");
	}

	public Customer dequeue() {
		if (front == null) {
			System.out.println("Antrian kosong! Tidak ada pelanggan untuk dilayani.");
			return null;
		}

		Customer servedCustomer = front.customer;
		front = front.next;

		if (front == null) {
			rear = null;
		}

		System.out.println("Mekanik sedang melayani: " + servedCustomer);
		return servedCustomer;
	}

	public void displayQueue() {
		if (front == null) {
			System.out.println("Tidak ada pelanggan dalam antrian.");
			return;
		}

		System.out.println("\n**Daftar Antrian Holy Garage**");
		Node temp = front;
		while (temp != null) {
			System.out.println(temp.customer);
			temp = temp.next;
		}
	}
}
