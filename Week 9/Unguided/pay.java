package tugas;
import java.util.Scanner;

public class pay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketQueue queue = new TicketQueue();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Customer");
            System.out.println("2. Hapus Customer");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            
            int choice = scanner.nextInt(); 
            scanner.nextLine();

            switch (choice) { 
                case 1:
                    System.out.print("Masukkan nama customer: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan nomor tiket: ");
                    int ticketNumber = scanner.nextInt();
                    queue.addCustomer(name, ticketNumber);
                    break;
                    
                case 2:
                    System.out.print("Masukkan nomor tiket yang akan dihapus: ");
                    int removeTicket = scanner.nextInt();
                    queue.removeCustomer(removeTicket);
                    break;
                    
                case 3:
                    System.out.println("Daftar Antrian:");
                    queue.displayQueue();
                    break;
                    
                case 4:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}