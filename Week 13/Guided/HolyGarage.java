package tugas;

public class HolyGarage {
	private GarageQueue queue;
	private Mechanic mechanic;

	public HolyGarage(String mechanicName) {
		this.queue = new GarageQueue();
		this.mechanic = new Mechanic(mechanicName);
	}

	public void addCustomer(String name, String motorType) {
		queue.enqueue(name, motorType);
	}

	public void serveNextCustomer() {
		Customer nextCustomer = queue.dequeue();
		if (nextCustomer != null) {
			mechanic.serveCustomer(nextCustomer);
		}
	}

	public void showQueue() {
		queue.displayQueue();
	}

}
