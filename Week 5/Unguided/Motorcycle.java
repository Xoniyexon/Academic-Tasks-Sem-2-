package tugas;

class Motorcycle extends Vehicle {
	Motorcycle(String brand, String model){
		super(brand, model);
	}
	
	@Override
	void startEngine() {
		System.out.println(brand + " " + model + ": Mesin motor dinyalakan.");
	}
	
	@Override
	void honk() {
		System.out.println(brand + " " + model + ": Fein! Fein!");
	}
	@Override
	void stopEngine() {
		System.out.println(brand + " " + model + ": Mesin motor dimatikan.");
	}

}
