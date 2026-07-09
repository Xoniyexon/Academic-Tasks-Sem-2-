package tugas;

import java.util.*;

public class LibraryManager {
	private Map<String, Book> bookCollections;
	private Map<String, List<String>> borrowedBooks;
	private Set<String> VIPMembers;

	public LibraryManager() {
		this.bookCollections = new HashMap<>();
		this.borrowedBooks = new HashMap<>();
		this.VIPMembers = new HashSet<>();
	}

	public void addBook(Book book) {
		bookCollections.put(book.getId(), book);
	}

	public void displayBooks() {
		System.out.println("=== Available Books ===");
		for (Book book : bookCollections.values()) {
			System.out.println(book);
		}
	}

	public void borrowBook(String studentId, String bookId) {
		if (!bookCollections.containsKey(bookId)) {
			System.out.println("Books ID not found.");
			return;
		}

		Book book = bookCollections.get(bookId);

		if (!book.isAvailable()) {
			System.out.println("Book '" + book.getTitle() + "' is currently not available.");
			return;
		}

		borrowedBooks.putIfAbsent(studentId, new ArrayList<>());
		borrowedBooks.get(studentId).add(bookId);
		book.setAvailable(false);

		System.out.println("Book '" + book.getTitle() + "' borrowed succesfully.");
	}

	public void returnBook(String studentId, String bookId) {
		if (!bookCollections.containsKey(bookId)) {
			System.out.println("Books ID not found.");
			return;
		}

		if (!borrowedBooks.containsKey(studentId) || !borrowedBooks.get(studentId).contains(bookId)) {
			System.out.println("This book was not borrowed by you.");
			return;
		}

		borrowedBooks.get(studentId).remove(bookId);
		bookCollections.get(bookId).setAvailable(true);

		System.out.println("Book '" + bookCollections.get(bookId).getTitle() + "' returned succesfully!");
	}
	
	public void displayVIPMembers() {
		System.out.println("=== VIP Members ===");
		if(VIPMembers.isEmpty()) {
			System.out.println("No VIP Members yet.");
		} else {
			for(String member : VIPMembers) {
				System.out.println("Student ID: " + member);
			}
		}
	}
}
