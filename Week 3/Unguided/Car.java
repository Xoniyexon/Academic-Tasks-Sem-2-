package Tugas;

public class Car extends Vehicle {
	String fuelType;
	int engineCapacity;

	public Car(String licensePlateNew, String brandNew, String modelNew, int yearNew, int mileageNew,
			String fuelTypeNew, int engineCapacityNew) {
		super(licensePlateNew, brandNew, modelNew, yearNew, mileageNew);
		this.fuelType = fuelTypeNew;
		this.engineCapacity = engineCapacityNew;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Fuel Type 		: " + fuelType);
		System.out.println("Engine Capacity		: " + engineCapacity + " cc");
	}

	public void calculateServiceCost(int mileage, String engineRepair, String tireChange) {
		int total = 500000;
		if (mileage > 10000) {
			total = total + 200000;
		}
		if (engineRepair.equalsIgnoreCase("y")) {
			total = total + 1000000;
		}
		if (tireChange.equalsIgnoreCase("y")) {
			total = total + 400000;
		}

		System.out.printf("Total			: Rp%,d%n", total);
		System.out.println();
	}
}
