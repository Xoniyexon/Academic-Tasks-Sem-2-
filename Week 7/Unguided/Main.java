package tugas;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LibraryManager manager = new LibraryManager();
		Scanner scanner = new Scanner(System.in);

		manager.addBook(new Book("1", "Java for Beginners", "Budi Berlinton Sitorus", 2020));
		manager.addBook(new Book("2", "Data Structures", "Antonius Sony Eko Nugroho, S.T., M.T.", 2018));
		manager.addBook(new Book("3", "Web Development", "Haditya Setiawan, S.Kom., M.M.S.I.", 2021));
		manager.addBook(new Book("4", "Python Programming", "Samuel Ady Sanjaya, S.T., M.T.", 2019));
		manager.addBook(new Book("5", "AI Fundamental Use", "Johan Setiawan, S.Kom., M.M., MBA", 2021));
		manager.addBook(new Book("6", "Machine Learning for Beginners", "Monika Evelin Johan, S.Kom., M.M.S.I.", 2019));

		while (true) {
			System.out.println("\n=== Library Management System ===");
			;
			System.out.println("1. View Available Book");
			System.out.println("2. Borrow a Book");
			System.out.println("3. Return a Book");
			System.out.println("4. View VIP Members");
			System.out.println("5. Exit");
			System.out.print("Choose an Option: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				manager.displayBooks();
				break;

			case 2:
				System.out.print("Enter Student ID: ");
				String studentId = scanner.nextLine();
				System.out.print("Enter Book ID: ");
				String bookId = scanner.nextLine();
				manager.borrowBook(studentId, bookId);
				break;

			case 3:
				System.out.print("Enter Student ID: ");
				studentId = scanner.nextLine();
				System.out.print("Enter Book ID: ");
				bookId = scanner.nextLine();
				manager.returnBook(studentId, bookId);
				break;

			case 4:
				manager.displayVIPMembers();
				break;

			case 5:
				System.out.println("Thank you for using the Library Management Systems!");
				scanner.close();
				return;

			default:
				System.out.println("Invalid Choice! Please try again.");
			}
		}
	}

}
