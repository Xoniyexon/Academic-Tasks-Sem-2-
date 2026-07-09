package tugas;

import java.util.Scanner;
public class NaisantaraPerpus {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		
		library.addBook("Object Oriented Programming", "Samuel Ady Sanjaya");
		library.addBook("The Data Warehouse Toolkit", "Nofriyadi Nurdam");
		library.addBook("Algorithm and Programming", "Agus Sulaiman");
		
		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Tambah Buku");
			System.out.println("2. Pinjam Buku");
			System.out.println("3. Lihat Buku");
			System.out.println("4. Keluar");
			System.out.println("Pilih Menu: ");
			int pilihan = scanner.nextInt();
			scanner.nextLine();
			
			switch (pilihan) {
			case 1 : 
				System.out.println("Masukkan judul buku: ");
				String title = scanner.nextLine();
				System.out.println("Masukkan nama penulis: ");
				String author = scanner.nextLine();
				library.addBook(title, author);
				break;
			case 2 : 
				library.borrowBook();
				break;
			case 3 : 
				library.displayBooks();
				break;
			case 4 : 
				System.out.println("Keluar dari program.");
				scanner.close();
				return;
			default : 
				System.out.println("Pilihan tidak valid.");
				
			}
		}
	}
}
