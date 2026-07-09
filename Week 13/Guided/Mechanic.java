package tugas;

public class Mechanic {
	private String name;

	public Mechanic(String name) {
		this.name = name;
	}

	public void serveCustomer(Customer customer) {
		if (customer != null) {
			System.out.println("Mekanik " + name + " sedang memperbaiki motor pelanggan: " + customer.getName());
		}
	}

}
