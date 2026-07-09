package tugas;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LoanHandler loanHandler = new LoanHandler();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n--- Sistem Peminjaman Buku ---");
			System.out.println("1. Tambahkan Peminjaman");
			System.out.println("2. Tampilkan Semua Peminjaman");
			System.out.println("3. Hapus Peminjaman");
			System.out.println("4. Cari Peminjaman");
			System.out.println("5. Update Tanggal Pengembalian");
			System.out.println("0. Keluar");
			System.out.println("Pilih Menu: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("ID Peminjaman: ");
				int loanId = sc.nextInt();
				sc.nextLine();
				System.out.println("Nama Peminjam: ");
				String borrowerName = sc.nextLine();
				System.out.println("Judul Buku: ");
				String bookTitle = sc.nextLine();
				System.out.println("Penulis Buku: ");
				String bookAuthor = sc.nextLine();
				System.out.println("Tanggal Pinjam (dd/MM/yyyy): ");
				String borrowDate = sc.nextLine();
				System.out.println("Tanggal Kembali (dd/MM/yyyy): ");
				String returnDate = sc.nextLine();
				loanHandler.addLoan(loanId, borrowerName, bookTitle, bookAuthor, borrowDate, returnDate);
				break;
			case 2:
				loanHandler.displayLoans();
				break;
			case 3:
				System.out.println("Masukkan ID untuk dihapus: ");
				int deleteId = sc.nextInt();
				loanHandler.removeLoan(deleteId);
				break;
			case 4:
				System.out.println("Masukkan ID atau nama: ");
				String keyword = sc.nextLine();
				loanHandler.searchLoan(keyword);
				break;
			case 5:
				System.out.println("ID Peminjaman: ");
				int updateId = sc.nextInt();
				sc.nextLine();
				System.out.println("Tanggal Kembali Baru (dd/MM/yyyy): ");
				String newReturnDate = sc.nextLine();
				loanHandler.updateReturnDate(updateId, newReturnDate);
				break;
			case 0:
				System.out.println("Keluar dari sistem...");
				return;
			default:
				System.out.println("Pilihan tidak valid.\n");
			}

		}
		
	}

}
