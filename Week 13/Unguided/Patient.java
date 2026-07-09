package tugas;

public class Patient {
	private int queueNumber;
	private String name;

	public Patient(int queueNumber, String name) {
		this.queueNumber = queueNumber;
		this.name = name;
	}

	public int getQueueNumber() {
		return queueNumber;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "No. " + queueNumber + " " + name;
	}
}
