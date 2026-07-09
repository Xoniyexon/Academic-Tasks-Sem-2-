package tugas;

public class AbstractionVehicle {
	public static void main(String[] args) {
		Car car = new Car("Toyota", "Corolla");
		Motorcycle motorcycle = new Motorcycle("Yamaha", "R15");
		Truck truck = new Truck("Mitsubishi", "Fuso");
		
		
		Vehicle[] daftarKendaraan = {car, motorcycle, truck};
		
		for (Vehicle vehicle : daftarKendaraan) {
			vehicle.startEngine();
			vehicle.honk();
			vehicle.stopEngine();
			System.out.println();
		}
	}

}
