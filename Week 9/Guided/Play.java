package tugas;

import java.util.Scanner;

public class Play {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Playlist playlist = new Playlist();
		int choice;
		do {
			System.out.println("\n Menu Playlist ");
			System.out.println("1. Tambah Lagu");
			System.out.println("2. Hapus Lagu");
			System.out.println("3. Lihat Playlist");
			System.out.println("4. Putar Lagu Saat Ini");
			System.out.println("5. Putar Lagu Berikutnya");
			System.out.println("6. Putar Lagu Sebelumnya");
			System.out.println("7. Keluar");
			System.out.println("Pilihan Anda: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Masukkan judul lagu: ");
				String title = scanner.nextLine();
				System.out.println("Masukkan nama artis: ");
				String artist = scanner.nextLine();
				playlist.addSong(title, artist);
				break;
				
			case 2:
				System.out.println("Masukkan judul lagu yang ingin dihapus: ");
				String removeTitle = scanner.nextLine();
				playlist.removeSong(removeTitle);
				break;
				
			case 3:
				playlist.displayPlaylist();
				break;
				
			case 4:
				playlist.playCurrent();
				break;
				
			case 5:
				playlist.playNext();
				break;
				
			case 6:
				playlist.playPrevious();
				break;
				
			case 7:
				System.out.println("Keluar dari playlist...");
				return;
			default:
				System.out.println("Pilihan Salah, Pilih Kembali!");
			}
		} while (choice != 7);

		scanner.close();
		}

}
