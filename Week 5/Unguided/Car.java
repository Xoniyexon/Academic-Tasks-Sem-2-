package tugas;

class Car extends Vehicle {
	Car (String brand, String model){
		super(brand, model);
	}
	
	@Override 
	void startEngine() {
		System.out.println(brand + " " + model + ": Mesin mobil dinyalakan.");
	}
	
	@Override
	void stopEngine() {
		System.out.println(brand + " " + model + ": Mesin mobil dimatikan.");
	}
	
	@Override
	void honk() {
		System.out.println(brand + " " + model + ": Honk! Honk!");
	}
}
