package project;

public class CartStack {

	// INNER CLASS: Node untuk Stack
	private class StackNode {
		KioskItem item;
		StackNode next;

		public StackNode(KioskItem item) {
			this.item = item;
			this.next = null;
		}
	}

	private StackNode top; // Menunjuk ke elemen paling atas di tumpukan

	public CartStack() {
		this.top = null;
	}

	// Menambahkan barang ke tumpukan paling atas (PUSH)
	public void push(KioskItem item) {
		StackNode newNode = new StackNode(item);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode; // Top bergeser ke node yang baru masuk
		}
		System.out.println("[Sukses] " + item.getItemName() + " dimasukkan ke keranjang.");
	}

	// Mengeluarkan barang terakhir yang dimasukkan (POP / UNDO)
	public KioskItem pop() {
		if (top == null) {
			System.out.println("[Info] Keranjang kosong, tidak ada yang bisa dibatalkan.");
			return null;
		}
		StackNode temp = top;
		top = top.next; // Geser top ke elemen di bawahnya
		System.out.println("[Undo] " + temp.item.getItemName() + " berhasil dibatalkan dari keranjang.");
		return temp.item;
	}

	// Menampilkan seluruh isi keranjang dari atas ke bawah
	public void displayCart() {
		if (top == null) {
			System.out.println("[Info] Keranjang belanja kosong.");
			return;
		}
		System.out.println("\n--- ISI KERANJANG KOPERASI (STACK) ---");
		StackNode current = top;
		int no = 1;
		double total = 0;

		while (current != null) {
			System.out.println(no + ". " + current.item.toString());
			total += current.item.getSubtotal();
			current = current.next;
			no++;
		}
		System.out.println("--------------------------------------");
		System.out.println("Total Estimasi Belanja: Rp" + total);
	}
}