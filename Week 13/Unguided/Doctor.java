package tugas;

public class Doctor {
	private String name;

	public Doctor(String name) {
		this.name = name;
	}

	public void servePatient(Patient patient) {
		if (patient != null) {
			System.out.println("Dokter " + name + " sedang melayani: No. " + patient.getQueueNumber() +  " - " + patient.getName());
		}
	}
}
