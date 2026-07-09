package project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	// Menggunakan static scanner agar bisa diakses oleh semua method menu
	static Scanner scanner = new Scanner(System.in);
	// Inisialisasi linked list secara global/static agar datanya persisten selama
	// program berjalan
	static ContractLinkedList contractList = new ContractLinkedList();
	static ServiceQueue serviceQueue = new ServiceQueue();
	static ServiceQueue lnfQueue = new ServiceQueue();
	static CartStack cartStack = new CartStack();
	static BillableLinkedList daftarTagihanGlobal = new BillableLinkedList();

	public static void main(String[] args) {
		Room kamar1 = new Room("R101", "Reguler", 1200000);
		Contract contract1 = new Contract("C001", "Pondan Wicaksana", kamar1, 3);
		contractList.addContract(contract1);
		daftarTagihanGlobal.add(contract1);

		Room kamar2 = new Room("V205", "VIP", 2500000);
		Contract contract2 = new Contract("C002", "Joban Setiadi", kamar2, 6);
		contractList.addContract(contract2);
		daftarTagihanGlobal.add(contract2);

		Room kamar3 = new Room("R102", "Reguler", 1200000);
		Contract contract3 = new Contract("C003", "Fitriadi", kamar3, 12);
		contractList.addContract(contract3);
		daftarTagihanGlobal.add(contract3);

		boolean isRunning = true;

		while (isRunning) {
			System.out.println("========================================");
			System.out.println("   SISTEM MANAJEMEN OEMAH-KU");
			System.out.println("========================================");
			System.out.println("1. Manajemen Kontrak");
			System.out.println("2. Layanan Dormi");
			System.out.println("3. Lost and Found");
			System.out.println("4. Koperasi (Kiosk)");
			System.out.println("5. Pembayaran");
			System.out.println("0. Keluar");
			System.out.print("Pilih menu utama (0-5): ");

			try {
				int pilihan = scanner.nextInt();
				scanner.nextLine();

				switch (pilihan) {
				case 1:
					menuKontrak();
					break;
				case 2:
					menuLayananDormi();
					break;
				case 3:
					menuLostAndFound();
					break; // Panggil method baru
				case 4:
					menuKoperasi();
					break;
				case 5:
					menuPembayaran();
					break;
				case 0:
					isRunning = false;
					System.out.println("Menutup program... Terima kasih!");
					break;
				default:
					System.out.println("[!] Pilihan tidak valid. Silakan masukkan angka 0-5.");
				}
			} catch (InputMismatchException e) {
				System.out.println("[Error] Input tidak valid! Harap masukkan angka.");
				scanner.nextLine();
			}
		}
		scanner.close();
	}

	// --- SUB-MENU KONTRAK ---
	private static void menuKontrak() {
		boolean back = false;
		while (!back) {
			System.out.println("\n--- MANAJEMEN KONTRAK ---");
			System.out.println("1. New Contract (Create)");
			System.out.println("2. View All Contracts (Read)");
			System.out.println("3. Update Contract (Update)");
			System.out.println("4. Delete Contract (Delete)");
			System.out.println("0. Kembali ke Menu Utama");
			System.out.print("Pilih menu: ");

			try {
				int pilihan = scanner.nextInt();
				scanner.nextLine();

				switch (pilihan) {
				case 1:
					System.out.println("\n--- NEW CONTRACT ---");
					System.out.print("Masukkan ID Kontrak: ");
					String id = scanner.nextLine();

					// VALIDASI: Langsung cek ID sebelum lanjut input data lain
					if (contractList.findNode(id) != null) {
						System.out.println("[Error] Gagal! ID Kontrak '" + id + "' sudah terdaftar di sistem.");
						break; // Langsung keluar dari case 1, batal lanjut input
					}

					System.out.print("Masukkan Nama Penghuni: ");
					String nama = scanner.nextLine();

					System.out.println("\n--- DAFTAR HARGA KAMAR OEMAH-KU ---");
					System.out.println("1. Reguler (Awalan R) - Rp2.100.000 / bulan");
					System.out.println("2. VIP     (Awalan V) - Rp2.500.000 / bulan");
					System.out.println("-----------------------------------");
					
					System.out.print("Masukkan Nomor Kamar (contoh R101 / V206): ");
					String noKamar = scanner.nextLine().toUpperCase();

					// VALIDASI : FORMAT KODE KAMAR, BATAS LANTAI & RUANGAN
					if (noKamar.length() != 4) {
						System.out.println("[Error] Format salah! Kode kamar harus 4 karakter (contoh: R101).");
						break;
					}

					char prefix = noKamar.charAt(0); // Huruf pertama (R / V)
					char lantaiChar = noKamar.charAt(1); // Karakter kedua (Lantai)
					String noUrutStr = noKamar.substring(2); // Dua digit terakhir (Nomor Ruangan)

					// Validasi huruf depan
					if (prefix != 'R' && prefix != 'V') {
						System.out.println("[Error] Kode kamar harus diawali 'R' (Reguler) atau 'V' (VIP)!");
						break;
					}

					// Validasi batasan maksimal lantai (Maksal 3 Lantai: 1-3)
					if (lantaiChar < '1' || lantaiChar > '3') {
						System.out.println(
								"[Error] Lantai tidak valid! Oemah-ku hanya memiliki Lantai 1 sampai Lantai 3.");
						break;
					}

					// Validasi batasan ruangan per lantai (Maksimal 6 Ruangan: 01-06)
					try {
						int noUrut = Integer.parseInt(noUrutStr);
						if (noUrut < 1 || noUrut > 6) {
							System.out.println(
									"[Error] Ruangan tidak tersedia! Tiap lantai hanya memiliki ruangan 01 hingga 06.");
							break;
						}
					} catch (NumberFormatException e) {
						System.out.println("[Error] Dua digit terakhir kode kamar harus berupa angka!");
						break;
					}

					if (contractList.findNodeByRoomNumber(noKamar) != null) {
						System.out.println(
								"[Error] Gagal! Kamar nomor '" + noKamar + "' sudah ditempati oleh penghuni lain.");
						break;
					}

					System.out.print("Masukkan Tipe Kamar (Reguler/VIP): ");
					String tipe = scanner.nextLine();

					// Validasi kecocokan antara tipe kamar dan kode depan yang dimasukkan
					if (prefix == 'R' && !tipe.equalsIgnoreCase("Reguler")) {
						System.out.println("[Error] Konflik data! Kode kamar diawali 'R', tipe harus 'Reguler'.");
						break;
					} else if (prefix == 'V' && !tipe.equalsIgnoreCase("VIP")) {
						System.out.println("[Error] Konflik data! Kode kamar diawali 'V', tipe harus 'VIP'.");
						break;
					}

					double harga = 0;
					if (tipe.equalsIgnoreCase("Reguler")) {
						harga = 2100000;
					} else if (tipe.equalsIgnoreCase("VIP")) {
						harga = 2500000;
					}

					System.out.print("Masukkan Durasi Sewa (Bulan): ");
					int durasi = scanner.nextInt();
					scanner.nextLine();

					Room kamar = new Room(noKamar, tipe, harga);
					Contract kontrakBaru = new Contract(id, nama, kamar, durasi);
					contractList.addContract(kontrakBaru);
					daftarTagihanGlobal.add(kontrakBaru);

					System.out.println(
							"[Sukses] Kontrak baru atas nama " + nama + " (" + noKamar + ") berhasil didaftarkan!");
					break;

				case 2:
					contractList.displayAllContracts();
					break;

				case 3:
					System.out.println("\n--- UPDATE CONTRACT ---");
					System.out.print("Masukkan ID Kontrak yang ingin diubah: ");
					String idUbah = scanner.nextLine();

					// Simpan hasil pencarian ke dalam variabel targetNode
					Node targetNode = contractList.findNode(idUbah);

					if (targetNode != null) {
						// TAMPILKAN INFORMASI KONTRAK SAAT INI
						System.out.println("\n================ DATA KONTRAK SAAT INI ================");
						System.out.println(targetNode.contract.toString()); // memanggil toString() yang sudah rapi
						System.out.println("=======================================================");

						// Lanjutkan dengan meminta input perubahan data
						System.out.print("Masukkan Nama Penghuni Baru: ");
						String namaBaru = scanner.nextLine();
						System.out.print("Masukkan Durasi Baru (Bulan): ");
						int durasiBaru = scanner.nextInt();
						scanner.nextLine();

						contractList.updateContract(idUbah, namaBaru, durasiBaru);
						System.out.println("[Sukses] Data kontrak berhasil diperbarui.");
					} else {
						System.out.println("[!] ID Kontrak tidak ditemukan.");
					}
					break;

				case 4:
					System.out.println("\n--- DELETE CONTRACT ---");
					System.out.print("Masukkan ID Kontrak yang ingin dihapus: ");
					String idHapus = scanner.nextLine();

					if (contractList.deleteContract(idHapus)) {
						System.out.println("[Sukses] Kontrak berhasil dihapus.");
					} else {
						System.out.println("[!] Gagal menghapus, ID tidak ditemukan.");
					}
					break;

				case 0:
					back = true;
					break;
				default:
					System.out.println("[!] Pilihan tidak valid.");
				}
			} catch (InputMismatchException e) {
				System.out.println("[Error] Kesalahan input! Pastikan format data benar.");
				scanner.nextLine();
			}
		}
	}

	// --- SUB-MENU LAYANAN DORMI ---
	private static void menuLayananDormi() {
		boolean back = false;
		while (!back) {
			System.out.println("\n--- LAYANAN DORMI ---");
			System.out.println("1. Buat Request Baru (Masuk Antrian / Enqueue)");
			System.out.println("2. Selesaikan Request (Proses Antrian Terdepan / Dequeue)");
			System.out.println("3. Lihat Daftar Request (Read Queue)");
			System.out.println("0. Kembali ke Menu Utama");
			System.out.print("Pilih menu: ");

			try {
				int pilihan = scanner.nextInt();
				scanner.nextLine();

				switch (pilihan) {
				case 1:
					System.out.println("\n--- PILIH JENIS LAYANAN ---");
					System.out.println("1. Komplain Fasilitas");
					System.out.println("2. Request Pembersihan Kamar");
					System.out.println("3. Pesan Laundry");
					System.out.print("Pilih (1-3): ");

					int tipeLayanan = scanner.nextInt();
					scanner.nextLine();

					if (tipeLayanan >= 1 && tipeLayanan <= 3) {
						System.out.print("Masukkan ID Request (misal 01): ");
						String reqId = scanner.nextLine();

						// --- VALIDASI ID KEMBAR ---
						if (serviceQueue.isIdExist(reqId)) {
							System.out.println(
									"[Error] Gagal! ID Request '" + reqId + "' sudah ada di dalam antrian sistem.");
							break; // Langsung hentikan proses dan kembali ke menu
						}

						System.out.print("Nama Penghuni: ");
						String nama = scanner.nextLine();
						
						if (!contractList.isResidentExist(nama)) {
                            System.out.println("[Error] Akses Ditolak! '" + nama + "' tidak terdaftar sebagai penghuni aktif di Oemah-ku.");
                            System.out.println("Layanan asrama hanya dikhususkan untuk penghuni resmi.");
                            break;
                        }
						

						if (tipeLayanan == 1) {
							System.out.print("Kategori Komplain (Listrik/Air/Fasilitas/Lainnya): ");
							String kat = scanner.nextLine();
							System.out.print("Deskripsi Masalah: ");
							String desk = scanner.nextLine();
							Complaint comp = new Complaint(reqId, nama, kat, desk);
							serviceQueue.enqueue(comp);
							daftarTagihanGlobal.add(comp);

						} else if (tipeLayanan == 2) {
							System.out.print("Paket Pembersihan (Full / Toilet): ");
							String paket = scanner.nextLine();
							CleaningRequest cleanReq = new CleaningRequest(reqId, nama, paket);
							serviceQueue.enqueue(cleanReq);
							daftarTagihanGlobal.add(cleanReq);

						} else if (tipeLayanan == 3) {
							System.out.print("Berat Cucian (Kg): ");
							double berat = scanner.nextDouble();
							scanner.nextLine();
							LaundryRequest laundReq = new LaundryRequest(reqId, nama, berat);
							serviceQueue.enqueue(laundReq);
							daftarTagihanGlobal.add(laundReq);
						}
					} else {
						System.out.println("[!] Pilihan jenis layanan tidak valid.");
					}
					break;

				case 2:
					ServiceRequest diproses = serviceQueue.processNext();
					if (diproses != null) {
						System.out.println("\n[Berhasil] Memproses antrian berikut:");
						diproses.displayDetail();
						System.out.println("Status layanan telah diperbarui menjadi Resolved.");
					}
					break;

				case 3:
					serviceQueue.displayQueue();
					break;

				case 0:
					back = true;
					break;

				default:
					System.out.println("[!] Pilihan tidak valid.");
				}
			} catch (InputMismatchException e) {
				System.out.println("[Error] Kesalahan input! Pastikan format data benar.");
				scanner.nextLine();
			}
		}

	}

	// --- SUB-MENU LOST AND FOUND
	private static void menuLostAndFound() {
		boolean back = false;
		while (!back) {
			System.out.println("\n--- LOST AND FOUND ---");
			System.out.println("1. Lapor Kehilangan/Penemuan Baru (Enqueue)");
			System.out.println("2. Selesaikan Laporan berdasarkan ID (Search & Remove)");
			System.out.println("3. Lihat Daftar Laporan Aktif (Read Queue)");
			System.out.println("0. Kembali ke Menu Utama");
			System.out.print("Pilih menu: ");

			try {
				int pilihan = scanner.nextInt();
				scanner.nextLine();

				switch (pilihan) {
				case 1:
					System.out.println("\n--- BUAT LAPORAN BARU ---");
					System.out.print("Masukkan ID Laporan (misal 01): ");
					String reqId = scanner.nextLine();

					if (lnfQueue.isIdExist(reqId)) {
						System.out.println(
								"[Error] Gagal! ID Request '" + reqId + "' sudah ada di dalam antrian sistem.");
						break; // Langsung hentikan proses dan kembali ke menu
					}

					System.out.print("Nama Pelapor: ");
					String nama = scanner.nextLine();
					System.out.print("Nama Barang: ");
					String brg = scanner.nextLine();
					System.out.print("Terakhir dilihat di: ");
					String lokasi = scanner.nextLine();

					if (lokasi.trim().isEmpty()) {
						System.out.println("[!] Lokasi harus diisi untuk validasi pencarian!");
					} else {
						lnfQueue.enqueue(new LostAndFound(reqId, nama, brg, lokasi));
					}
					break;

				case 2:
					// LOGIKA BARU: Search berdasarkan ID
					System.out.print("\nMasukkan ID Laporan yang sudah selesai/ditemukan: ");
					String targetId = scanner.nextLine();

					// Memanggil method resolveById alih-alih processNext
					ServiceRequest diproses = lnfQueue.resolveById(targetId);

					if (diproses != null) {
						System.out.println("\n[Berhasil] Laporan berikut telah diselesaikan:");
						diproses.displayDetail();
						System.out.println("Barang telah dikembalikan/ditemukan (Status: Resolved).");
					}
					break;

				case 3:
					lnfQueue.displayQueue();
					break;

				case 0:
					back = true;
					break;

				default:
					System.out.println("[!] Pilihan tidak valid.");
				}
			} catch (InputMismatchException e) {
				System.out.println("[Error] Kesalahan input! Pastikan format data benar.");
				scanner.nextLine();
			}
		}
	}

	// --- SUB-MENU KOPERASI ---
	private static void menuKoperasi() {
		System.out.print("Nama Penghuni (Pembeli): ");
		String namaPembeli = scanner.nextLine();

		// VALIDASI & CARI DATA KONTRAK PENGHUNI
		Contract kontrakPenghuni = contractList.findContractByResidentName(namaPembeli);

		if (kontrakPenghuni == null) {
			System.out.println("[Error] Akses Ditolak! '" + namaPembeli + "' tidak terdaftar sebagai penghuni aktif Oemah-ku.");
			return; 
		}

		// AMBIL KERANJANG PRIBADI MILIK PENGHUNI TERSEBUT DARI KONTRAKNYA
		CartStack activeCartStack = kontrakPenghuni.getCartStack();

		// Master Data Barang Koperasi (Katalog Statis)
		String[] katalogBarang = { 
            "Indomie", "Telur", "Air Mineral 600mL", "Air Mineral 1L", 
            "Kopi Sachet", "Roti Kemasan", "Sabun Mandi", "Sampo", 
            "Tisu", "Pulpen", "Pensil", "Penghapus", "Label", "Print (per lembar)" 
        };
		
		double[] hargaBarang = { 
            3000, 2000, 3000, 6000, 
            2000, 5000, 1000, 1000, 
            5000, 3000, 3000, 2000, 1000, 1000 
        };

		boolean back = false;
		while (!back) {
			// Menampilkan nama sesi aktif pada header menu koperasi
			System.out.println("\n--- KOPERASI OEMAH-KU (Sesi: " + namaPembeli.toUpperCase() + ") ---");
			System.out.println("1. Tambah Barang/Layanan ke Keranjang");
			System.out.println("2. Lihat Keranjang Belanja (Display)");
			System.out.println("3. Batal/Undo Item Terakhir");
			System.out.println("0. Kembali ke Menu Utama");
			System.out.print("Pilih menu: ");

			try {
				int pilihan = scanner.nextInt();
				scanner.nextLine();

				switch (pilihan) {
				case 1:
					// Menampilkan List Produk
					System.out.println("\n================ KATALOG KOPERASI ===============");
					for (int i = 0; i < katalogBarang.length; i++) {
						System.out.printf("%2d. %-25s - Rp%,.0f\n", (i + 1), katalogBarang[i], hargaBarang[i]);
					}
					System.out.println("=================================================");
					
					System.out.print("Pilih Nomor Barang (1-" + katalogBarang.length + "): ");
					int noPilih = scanner.nextInt();
					
					if (noPilih < 1 || noPilih > katalogBarang.length) {
						System.out.println("[Error] Pilihan tidak valid! Masukkan angka sesuai nomor di katalog.");
						scanner.nextLine();
						break;
					}

					System.out.print("Jumlah (Qty): ");
					int jumlah = scanner.nextInt();
					scanner.nextLine();

					int index = noPilih - 1;
					String namaBarangTerpilih = katalogBarang[index];
					double hargaSatuanTerpilih = hargaBarang[index];

					KioskItem itemBaru = new KioskItem(namaPembeli, namaBarangTerpilih, hargaSatuanTerpilih, jumlah);
					
					// Gunakan activeCartStack milik individu, bukan milik global
					activeCartStack.push(itemBaru);
					daftarTagihanGlobal.add(itemBaru);
					break;

				case 2:
					// Menampilkan stack milik user aktif
					activeCartStack.displayCart();
					break;

				case 3:
					// Melakukan POP hanya pada tumpukan user aktif
					KioskItem itemBatal = activeCartStack.pop();
					if (itemBatal != null) {
						daftarTagihanGlobal.removeSpecificItem(itemBatal);
					}
					break;

				case 0:
					back = true;
					break;
				default:
					System.out.println("[!] Pilihan tidak valid.");
				}
			} catch (InputMismatchException e) {
				System.out.println("[Error] Kesalahan input! Pastikan Anda memasukkan angka yang valid.");
				scanner.nextLine(); 
			}
		}
	}

	// --- SUB-MENU PEMBAYARAN ---
	private static void menuPembayaran() {
		boolean back = false;
		while (!back) {
			System.out.println("\n--- PEMBAYARAN ---");
			System.out.println("1. Cetak Invoice Personal & Pelunasan");
			System.out.println("0. Kembali ke Menu Utama");
			System.out.print("Pilih menu: ");

			try {
				int pilihan = scanner.nextInt();
				scanner.nextLine();

				switch (pilihan) {
				case 1:
					if (daftarTagihanGlobal.isEmpty()) {
						System.out.println("[Info] Belum ada transaksi atau tagihan aktif di Oemah-ku saat ini.");
						break;
					}

					System.out.print("\nMasukkan Nama Penghuni untuk dicetak tagihannya: ");
					String targetNama = scanner.nextLine();

					if (!daftarTagihanGlobal.hasTransaction(targetNama)) {
						System.out.println("[Error] Gagal! Penghuni atas nama '" + targetNama
								+ "' tidak memiliki transaksi aktif di Oemah-ku.");
						break;
					}

					System.out.println("\n==============================================");
					System.out.println("     INVOICE TAGIHAN a/n: " + targetNama.toUpperCase());
					System.out.println("==============================================");

					double grandTotal = daftarTagihanGlobal.printInvoiceAndGetTotal(targetNama);

					System.out.println("==============================================");
					System.out.println("GRAND TOTAL YANG HARUS DIBAYAR: Rp" + String.format("%,.0f", grandTotal));
					System.out.println("==============================================");

					System.out.print("\nApakah tagihan ini akan dilunasi sekarang? (Y/N): ");
					String bayar = scanner.nextLine();

					if (bayar.equalsIgnoreCase("Y")) {
						daftarTagihanGlobal.removeByResidentName(targetNama);
						System.out.println("[Sukses] Pembayaran berhasil diproses! Tagihan atas nama " + targetNama
								+ " telah lunas.");
					} else if (bayar.equalsIgnoreCase("N")) {
						System.out.println(
								"[Info] Pembayaran ditunda. Data tagihan masih tersimpan dengan aman di sistem.");
					} else {
						System.out.println("[!] Input tidak dikenali. Proses pembayaran dibatalkan secara otomatis.");
					}
					break;

				case 0:
					back = true;
					break;
				default:
					System.out.println("[!] Pilihan tidak valid.");
				}
			} catch (InputMismatchException e) {
				System.out.println("[Error] Input tidak valid! Harap masukkan angka.");
				scanner.nextLine();
			}
		}

	}
}