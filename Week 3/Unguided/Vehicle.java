package Tugas;

public class Vehicle {
	protected String licensePlate;
	protected String brand;
	protected String model;
	protected int year;
	protected int mileage;
	
	public Vehicle(String licensePlateNew, String brandNew, String modelNew, int yearNew, int mileageNew) {
		this.licensePlate = licensePlateNew;
		this.brand = brandNew;
		this.model = modelNew;
		this.year = yearNew;
		this.mileage = mileageNew;
	}
	
	public void displayInfo() {
		System.out.println("License Plate		: " + licensePlate);
		System.out.println("Brand 			: " + brand);
		System.out.println("Model 			: " + model);
		System.out.println("Year 			: " + year);
		System.out.println("Mileage			: " + mileage + " km");
	}

}
