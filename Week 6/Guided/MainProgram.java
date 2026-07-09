package Tugas;

import java.util.Scanner;

public class MainProgram {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== Pemesanan Tiket Bioskop ===");
		System.out.println("Pilih jenis tiket:");
		System.out.println("1. Reguler (Rp50.000)");
		System.out.println("2. VIP (Rp100.000 + Rp20.000 untuk snack)");
		System.out.println("3. Premiere (Rp200.000 + Rp50.000 untuk dinner)");
		System.out.print("Masukkan pilihan (1-3): ");

		int pilihan = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Masukkan nama film: ");
		String film = scanner.nextLine();

		System.out.print("Masukkan studio: ");
		String studio = scanner.nextLine();

		System.out.print("Masukkan jumlah tiket: ");
		int jumlahTiket = scanner.nextInt();

		TiketBioskop tiket = null;

		if (pilihan == 1) {
			tiket = new TiketReguler(film, studio, jumlahTiket, 50000);
		} else if (pilihan == 2) {
			System.out.print("Ingin menambahkan snack? (ya/tidak): ");
			String snackInput = scanner.next();
			boolean includeSnack = false;
			if (snackInput.equalsIgnoreCase("ya")) {
				includeSnack = true;
			}
			tiket = new TiketVIP(film, studio, jumlahTiket, 100000, includeSnack);
		} else if (pilihan == 3) {
			System.out.print("Ingin menambahkan dinner? (ya/tidak): ");
			String dinnerInput = scanner.next();
			boolean includeDinner = false;
			if (dinnerInput.equalsIgnoreCase("ya")) {
				includeDinner = true;
			}
			tiket = new TiketPremiere(film, studio, jumlahTiket, 200000, includeDinner);
		} else {
			System.out.println("Pilihan tidak valid!");
			System.exit(0);
		}

		System.out.println("\n=== Detail Tiket ===");
		tiket.tampilkanInfo();

		scanner.close();
	}

}
