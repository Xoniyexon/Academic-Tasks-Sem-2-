package tugas;

import java.util.Scanner;

public class HolyGarageApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HolyGarage garage = new HolyGarage("Lorem");
		boolean exit = false;

		System.out.println("=== Selamat Datang di Holy Garage ===");

		while (!exit) {
			System.out.println("\nMenu:");
			System.out.println("1. Tambah Pelanggan ke Antrian");
			System.out.println("2. Tampilkan Antrian");
			System.out.println("3. Layani Pelanggan Berikutnya");
			System.out.println("4. Keluar");
			System.out.print("Pilihan Anda: ");
			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				System.out.print("Nama Pelanggan: ");
				String name = scanner.nextLine();
				System.out.print("Tipe Motor: ");
				String motor = scanner.nextLine();
				garage.addCustomer(name, motor);
				break;

			case 2:
				garage.showQueue();
				break;

			case 3:
				garage.serveNextCustomer();
				break;

			case 4:
				exit = true;
				System.out.println("Terima kasih telah menggunakan Holy Garage.");
				break;

			default:
				System.out.println("Pilihan tidak valid. Coba lagi!");
			}
		}

		scanner.close();
	}

}