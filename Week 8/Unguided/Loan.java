package tugas;

public class Loan {
	int loanId;
	String borrowerName;
	String bookTitle;
	String bookAuthor;
	String borrowDate;
	String returnDate;
	Loan next;
	
	public Loan(int loanId, String borrowerName, String bookTitle, String bookAuthor, String borrowDate, String returnDate) {
		this.loanId = loanId;
        this.borrowerName = borrowerName;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.next = null;
	}

}
