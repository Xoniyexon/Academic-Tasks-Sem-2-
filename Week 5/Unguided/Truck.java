package tugas;

class Truck extends Vehicle {
	Truck(String brand, String model){
		super(brand, model);
	}
	
	@Override
	void startEngine() {
		System.out.println(brand + " " + model + ": Mesin truk dinyalakan.");
	}
	
	@Override
	void honk() {
		System.out.println(brand + " " + model + ": HOOONK!");
	}
	@Override
	void stopEngine() {
		System.out.println(brand + " " + model + ": Mesin truk dimatikan.");
	}

}
