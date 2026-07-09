package Tugas;

public class Truck extends Vehicle {
	int maxLoad;

	public Truck(String licensePlateNew, String brandNew, String modelNew, int yearNew, int mileageNew,
			int maxLoadNew) {
		super(licensePlateNew, brandNew, modelNew, yearNew, mileageNew);
		this.maxLoad = maxLoadNew;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Max Load 		: " + maxLoad);
	}

	public void calculateServiceCost(int mileage, String engineRepair, String tireChange) {
		int total = 1000000;
		if (mileage > 10000) {
			total = total + 200000;
		}
		if (engineRepair.equalsIgnoreCase("y")) {
			total = total + 2000000;
		}
		if (tireChange.equalsIgnoreCase("y")) {
			total = total + 800000;
		}

		System.out.printf("Total			: Rp%,d%n", total);
		System.out.println();
	}

}
