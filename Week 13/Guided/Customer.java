package tugas;

public class Customer {
	private int queueNumber;
	private String name;
	private String motorType;

	public Customer(int queueNumber, String name, String motorType) {
		this.queueNumber = queueNumber;
		this.name = name;
		this.motorType = motorType;
	}

	public int getQueueNumber() {
		return queueNumber;
	}

	public String getName() {
		return name;
	}

	public String getMotorType() {
		return motorType;
	}

	@Override
	public String toString() {
		return "No. Antrian: " + queueNumber + " | Nama: " + name + " | Motor: " + motorType;
	}

}
