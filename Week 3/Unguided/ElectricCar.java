package Tugas;

public class ElectricCar extends Vehicle {
	int batteryCapacity;

	public ElectricCar(String licensePlateNew, String brandNew, String modelNew, int yearNew, int mileageNew,
			int batteryCapacityNew) {
		super(licensePlateNew, brandNew, modelNew, yearNew, mileageNew);
		this.batteryCapacity = batteryCapacityNew;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Battery Capacity 	: " + batteryCapacity + " kWh");
	}

	public void calculateServiceCost(int mileage, String engineRepair, String tireChange) {
		int total = 700000;
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
