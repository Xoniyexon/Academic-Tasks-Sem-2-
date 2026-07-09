package tugas;

abstract class Vehicle {
	String brand, model;
	
	Vehicle (String brand, String model){
		this.brand = brand;
		this.model = model;
	}
	
	abstract void startEngine();
	abstract void stopEngine();
	abstract void honk();
}
