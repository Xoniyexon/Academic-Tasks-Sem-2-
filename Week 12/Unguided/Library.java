package tugas;

public class Library {
    private StackLinkedList<Book> stack = new StackLinkedList<>();

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        stack.push(newBook);
        System.out.println("Added: " + newBook.toString()); 
    }

    public void borrowBook() {
        Book borrowedBook = stack.pop();
        if (borrowedBook != null) {
            System.out.println("Borrowed: " + borrowedBook.toString());
        }
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        stack.display();
    }
}
