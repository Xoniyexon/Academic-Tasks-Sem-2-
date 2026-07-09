package project;

public class BillableLinkedList {

	// Buat Node Baru khusus Pembayaran
	private class Node {
		Billable data;
		Node next;

		public Node(Billable data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;

	public BillableLinkedList() {
		this.head = null;
	}

	// METHOD ADD: Menambah tagihan ke belakang (Tail)
	public void add(Billable item) {
		Node newNode = new Node(item);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// METHOD ISEMPTY: Cek apakah keranjang kosong
	public boolean isEmpty() {
		return head == null;
	}

	// METHOD KHUSUS PEMBAYARAN: Cetak Invoice & Hitung Total
	public double printInvoiceAndGetTotal(String targetName) {
		double grandTotal = 0;
		Node current = head;

		while (current != null) {
			if (current.data.getResidentName().equalsIgnoreCase(targetName) && current.data.getBillingAmount() > 0) {
				System.out.println("- " + current.data.getBillingDescription());
				System.out.println("  Biaya: Rp" + String.format("%,.0f", current.data.getBillingAmount()));
				grandTotal += current.data.getBillingAmount();
			}
			current = current.next;
		}
		return grandTotal;
	}

	// METHOD LUNAS: Hapus semua tagihan milik 1 orang
	public void removeByResidentName(String targetName) {
		// Jika tagihan yang mau dihapus ada di paling depan (Head)
		while (head != null && head.data.getResidentName().equalsIgnoreCase(targetName)) {
			head = head.next;
		}

		// Jika tagihan yang mau dihapus ada di tengah atau belakang
		Node current = head;
		while (current != null && current.next != null) {
			if (current.next.data.getResidentName().equalsIgnoreCase(targetName)) {
				current.next = current.next.next; // Putus pointer-nya
			} else {
				current = current.next; // Geser maju jika tidak ada yang dihapus
			}
		}
	}

	// METHOD UNDO KOPERASI: Hapus 1 item spesifik
	public void removeSpecificItem(Billable targetItem) {
		if (head == null)
			return;

		if (head.data == targetItem) {
			head = head.next;
			return;
		}

		Node current = head;
		while (current.next != null) {
			if (current.next.data == targetItem) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	// METHOD VALIDASI: Cek apakah penghuni punya transaksi
	public boolean hasTransaction(String targetName) {
		Node current = head;
		while (current != null) {
			if (current.data.getResidentName().equalsIgnoreCase(targetName) && current.data.getBillingAmount() > 0) {
				return true; // Orang ini punya transaksi
			}
			current = current.next;
		}
		return false; // Tidak ada transaksi sama sekali
	}
}