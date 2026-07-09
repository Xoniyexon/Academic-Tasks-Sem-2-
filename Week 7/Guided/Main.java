package tugas;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		RestaurantManager manager = new RestaurantManager();
		Scanner scanner = new Scanner(System.in);

		manager.addMenu(new Menu("1", "Nasi Goreng", 25000.0));
		manager.addMenu(new Menu("2", "Ayam Bakar", 30000.0));
		manager.addMenu(new Menu("3", "Es Teh", 5000.0));
		manager.addMenu(new Menu("4", "Es Jeruk", 15000.0));
		manager.addMenu(new Menu("5", "Steak Tenderloin", 65000.0));
		manager.addMenu(new Menu("6", "Crispy Fried Chicken", 35000.0));
		manager.addMenu(new Menu("7", "Sate Ayam", 35000.0));
		manager.addMenu(new Menu("8", "Sate Kambing", 45000.0));
		manager.addMenu(new Menu("9", "Gulai Ayam", 35000.0));
		manager.addMenu(new Menu("10", "Gulai Kambing", 55000.0));
		manager.addMenu(new Menu("11", "Spaghetti Bolognese", 30000.0));
		manager.addMenu(new Menu("12", "Indomie", 10000.0));
		manager.addMenu(new Menu("13", "Batagor", 15000.0));
		manager.addMenu(new Menu("14", "Nasi", 7000.0));
		manager.addMenu(new Menu("15", "Mie Ayam", 25000.0));
		manager.addMenu(new Menu("16", "Bapao", 20000.0));
		manager.addMenu(new Menu("17", "Dimsum Goreng", 35000.0));
		manager.addMenu(new Menu("18", "Es Doger", 15000.0));
		manager.addMenu(new Menu("19", "Es Buah", 12000.0));

		while (true) {
			System.out.println("\n=== Menu Utama ===");
			System.out.println("1. Lihat Menu");
			System.out.println("2. Buat Pesanan");
			System.out.println("3. Lihat Pelanggan VIP");
			System.out.println("4. Lihat Pesanan dalam Antrian");
			System.out.println("5. Proses Pesanan");
			System.out.println("6. Keluar");
			System.out.print("Pilih menu: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 6) {
				System.out.println("Thank You!");
				break;
			}
			
			switch (choice) {
			case 1:
				manager.displayMenu();
				break;
			case 2:
				System.out.print("\nMasukkan nama pelanggan: ");
				String nama = scanner.nextLine();

				if (nama.matches(".*\\d.*")) {
					System.out.println("Nama pelanggan tidak boleh dalam angka!");
					break;
				}

				Map<String, Integer> items = new HashMap<>();
				while (true) {
					System.out.print("Masukkan kode menu: ");
					String kodeMenu = scanner.nextLine();
					System.out.print("Masukkan jumlah: ");
					int jumlah = scanner.nextInt();
					scanner.nextLine();

					items.put(kodeMenu, jumlah);

					System.out.print("Tambah menu lain? (y/n): ");
					String lagi = scanner.nextLine();
					if (lagi.equalsIgnoreCase("n"))
						break;
				}

				manager.placeOrder(nama, items);

				System.out.print("\nApakah ingin mendaftar sebagai pelanggan VIP? (y/n): ");
				String vipChoice = scanner.nextLine();
				if (vipChoice.equalsIgnoreCase("y")) {
					manager.addVipCustomer(new Member(nama));
					System.out.println("Selamat! Anda sekarang pelanggan VIP.");
				} else {
					System.out.println("Terima kasih sudah memesan. Tunggu sebentar makanan akan segera siap!");
				}
				break;

			case 3:
				manager.displayVipCustomers();
				break;
			case 4:
				manager.displayPendingOrders();
				break;
			case 5:
				manager.processOrder();
				break;
			default:
				System.out.println("Pilihan tidak valid!");
				break;
			}
		}
		scanner.close();
	}
}
