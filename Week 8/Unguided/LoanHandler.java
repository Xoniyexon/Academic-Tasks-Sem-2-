package tugas;

public class LoanHandler {
    private Loan head; 

    public LoanHandler() {
        this.head = null;
    }

    public void addLoan(int loanId, String borrowerName, String bookTitle, String bookAuthor, String borrowDate, String returnDate) {
        if (!ValidationHelper.isValidDate(borrowDate) || !ValidationHelper.isValidDate(returnDate)) {
            System.out.println("Format tanggal tidak valid. Gunakan dd/MM/yyyy.");
            return;
        }
        if (!ValidationHelper.isReturnDateValid(borrowDate, returnDate)) {
            System.out.println("Tanggal kembali harus setelah tanggal pinjam.");
            return;
        }
        if (!ValidationHelper.isUniqueLoanId(head, loanId)) {
            System.out.println("ID Peminjaman sudah ada.");
            return;
        }
        Loan newLoan = new Loan(loanId, borrowerName, bookTitle, bookAuthor, borrowDate, returnDate);
        
        if (head == null) { 
            head = newLoan; 
        } else {
            Loan current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newLoan; 
        }
        System.out.println("Peminjaman berhasil ditambahkan."); 
    }

    public void displayLoans() {
        if (head == null) {
            System.out.println("Tidak ada data peminjaman."); 
            return;
        }
        System.out.println("--- Daftar Peminjaman ---");
        Loan current = head;
        while (current != null) {
            System.out.println("ID: " + current.loanId + " | Nama: " + current.borrowerName + 
                               " | Buku: " + current.bookTitle + " by " + current.bookAuthor + 
                               " | Pinjam: " + current.borrowDate + " | Kembali: " + current.returnDate);
            current = current.next;
        }
    }

    public void searchLoan(String keyword) {
        if (head == null) {
            System.out.println("Tidak ada data peminjaman.");
            return;
        }
        
        boolean found = false;
        Loan current = head;
        
        while (current != null) {
            boolean matchName = current.borrowerName.toLowerCase().contains(keyword.toLowerCase());
            boolean matchId = false;

            try {
                if (current.loanId == Integer.parseInt(keyword)) {
                    matchId = true;
                }
            } catch (NumberFormatException e) {
            }

            if (matchName || matchId) {
                if (!found) {
                    System.out.println("Data ditemukan:"); 
                    found = true;
                }
                System.out.println("ID: " + current.loanId + " | Nama: " + current.borrowerName + 
                                   " | Buku: " + current.bookTitle + " | Tanggal Pinjam: " + 
                                   current.borrowDate + " | Tanggal Kembali: " + current.returnDate);
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("Data tidak ditemukan.");
        }
    }


    public void removeLoan(int loanId) {
        if (head == null) {
            System.out.println("Tidak ada data peminjaman.");
            return;
        }
        if (head.loanId == loanId) {
            head = head.next;
            System.out.println("Data berhasil dihapus."); 
            return;
        }

        Loan current = head;
        Loan previous = null;

        while (current != null && current.loanId != loanId) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Data tidak ditemukan.");
            return;
        }

        previous.next = current.next;
        System.out.println("Data berhasil dihapus."); 
    }

    public void updateReturnDate(int loanId, String newReturnDate) {
        if (!ValidationHelper.isValidDate(newReturnDate)) {
             System.out.println("Format tanggal tidak valid.");
             return;
        }

        Loan current = head;
        while (current != null) {
            if (current.loanId == loanId) {
                if (ValidationHelper.isReturnDateValid(current.borrowDate, newReturnDate)) {
                    current.returnDate = newReturnDate;
                    System.out.println("Tanggal kembali berhasil diperbarui."); 
                } else {
                    System.out.println("Tanggal kembali baru harus setelah tanggal pinjam.");
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Data peminjaman tidak ditemukan.");
    }
}