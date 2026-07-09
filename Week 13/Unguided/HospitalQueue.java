package tugas;

public class HospitalQueue {
	private Node front, rear;
	private int queueCounter;

	static class Node {
		Patient patient;
		Node next;

		Node(Patient patient) {
			this.patient = patient;
			this.next = null;
		}
	}

	public HospitalQueue() {
		this.front = this.rear = null;
		this.queueCounter = 1;
	}

	public void enqueue(String name) {
		Patient newPatient = new Patient(queueCounter++, name);
		Node newNode = new Node(newPatient);

		if (rear == null) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		System.out.println(
				"No. " + newPatient.getQueueNumber() + " - " + newPatient.getName() + " ditambahkan ke dalam antrian.");
	}

	public Patient dequeue() {
		if (front == null) {
			System.out.println("Antrian kosong! Tidak ada pasien untuk dilayani.");
			return null;
		}

		Patient servedPatient = front.patient;
		front = front.next;

		if (front == null) {
			rear = null;
		}
		return servedPatient;
	}

	public void displayQueue() {
		if (front == null) {
			System.out.println("Tidak ada pasien dalam antrian.");
			return;
		}

		System.out.println("Pasien dalam antrian:");
		Node temp = front;
		while (temp != null) {
			System.out.println("No. " + temp.patient.getQueueNumber() + " - " + temp.patient.getName());
			temp = temp.next;
		}
	}
}
