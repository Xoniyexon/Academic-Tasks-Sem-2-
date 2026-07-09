package tugas;

public class HolyHospital {
	private HospitalQueue queue;
	private Doctor doctor;

	public HolyHospital(String doctorName) {
		this.queue = new HospitalQueue();
		this.doctor = new Doctor(doctorName);
	}

	public void addPatient(String name) {
		queue.enqueue(name);
	}

	public void serveNextPatient() {
		Patient nextPatient = queue.dequeue();
		if (nextPatient != null) {
			doctor.servePatient(nextPatient);
		}
	}

	public void showQueue() {
		queue.displayQueue();
	}

}
