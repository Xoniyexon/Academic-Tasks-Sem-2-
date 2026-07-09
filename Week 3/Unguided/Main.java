package Tugas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Car vios = new Car("B 999 BL", "Toyota", "Vios", 2018, 12321, "Bensin", 2000);
		Car brio = new Car("B 888 FL", "Honda", "Brio", 2012, 30000, "Bensin", 1000);
		Truck dyna = new Truck("B 2000 GG", "Toyota", "Dyna", 2015, 42223, 5200);
		ElectricCar byd = new ElectricCar("B 1000 WAA", "BYD", "SEAL", 2024, 5856, 84);
		
		System.out.println("List Kendaraan: \n");
		vios.displayInfo();
		System.out.println("Apakah ada perbaikan mesin (y/n)?");
		String engineRepairVios = sc.nextLine();
		System.out.println("Apakah ada pergantian ban (y/n)?");
		String tireChangeVios = sc.nextLine();
		vios.calculateServiceCost(vios.mileage, engineRepairVios, tireChangeVios);
	
		brio.displayInfo();
		System.out.println("Apakah ada perbaikan mesin (y/n)?");
		String engineRepairBrio = sc.nextLine();
		System.out.println("Apakah ada pergantian ban (y/n)?");
		String tireChangeBrio = sc.nextLine();
		brio.calculateServiceCost(brio.mileage, engineRepairBrio, tireChangeBrio);
		
		dyna.displayInfo();
		System.out.println("Apakah ada perbaikan mesin (y/n)?");
		String engineRepairDyna = sc.nextLine();
		System.out.println("Apakah ada pergantian ban (y/n)?");
		String tireChangeDyna = sc.nextLine();
		dyna.calculateServiceCost(dyna.mileage, engineRepairDyna, tireChangeDyna);
		
		byd.displayInfo();
		System.out.println("Apakah ada perbaikan mesin (y/n)?");
		String engineRepairByd = sc.nextLine();
		System.out.println("Apakah ada pergantian ban (y/n)?");
		String tireChangeByd = sc.nextLine();
		byd.calculateServiceCost(byd.mileage, engineRepairByd, tireChangeByd);
		
		sc.close();
		
	}

}
