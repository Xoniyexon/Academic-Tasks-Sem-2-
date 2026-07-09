package tugas;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HolyHospital hospital = new HolyHospital("Dr. Andre");
		boolean exit = false;

		while (!exit) {
			System.out.println("=== Sistem Antrian Holy Hospital ===");
			System.out.println("1. Tambah Pasien");
			System.out.println("2. Layani Pasien");
			System.out.println("3. Lihat Antrian");
			System.out.println("4. Keluar");
			System.out.print("Pilih menu: ");

			int pilihan = scanner.nextInt();
			scanner.nextLine();

			switch (pilihan) {
			case 1:
				System.out.print("Masukkan nama pasien: ");
				String nama = scanner.nextLine();
				hospital.addPatient(nama);
				break;
			case 2:
				hospital.serveNextPatient();
				break;
			case 3:
				hospital.showQueue();
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("Pilihan tidak valid. Silakan coba lagi!");
				break;
			}
			System.out.println();
		}

		scanner.close();
	}
}