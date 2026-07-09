package project;

public class ServiceQueue {

	private class QueueNode {
		ServiceRequest request;
		QueueNode next;

		public QueueNode(ServiceRequest request) {
			this.request = request;
			this.next = null;
		}
	}

	private QueueNode front; // Elemen paling depan (yang akan diproses)
	private QueueNode rear; // Elemen paling belakang (yang baru masuk)

	public ServiceQueue() {
		this.front = null;
		this.rear = null;
	}

	// Menambahkan antrian baru (Enqueue)
	public void enqueue(ServiceRequest request) {
		QueueNode newNode = new QueueNode(request);
		if (rear == null) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		System.out.println("[Sukses] Permintaan berhasil masuk ke dalam antrian sistem.");
	}

	// Memproses antrian terdepan (Dequeue)
	public ServiceRequest processNext() {
		if (front == null) {
			System.out.println("[Info] Tidak ada antrian layanan saat ini.");
			return null;
		}
		QueueNode temp = front;
		front = front.next;

		if (front == null) {
			rear = null;
		}

		temp.request.setStatus("Resolved");
		return temp.request;
	}

	// Menampilkan seluruh antrian yang masih "Pending"
	public void displayQueue() {
		if (front == null) {
			System.out.println("[Info] Antrian kosong.");
			return;
		}
		System.out.println("\n--- DAFTAR ANTRIAN LAYANAN (QUEUE) ---");
		QueueNode current = front;
		int no = 1;
		while (current != null) {
			System.out.print(no + ". ");
			current.request.displayDetail();
			current = current.next;
			no++;
		}
	}

	// Mencari dan menyelesaikan request berdasarkan ID
	public ServiceRequest resolveById(String requestId) {
		if (front == null) {
			System.out.println("[Info] Daftar laporan kosong.");
			return null;
		}

		QueueNode current = front;
		QueueNode prev = null;

		// Looping untuk mencari ID yang cocok
		while (current != null) {
			if (current.request.getRequestId().equalsIgnoreCase(requestId)) {
				// Node Ditemukan! Sekarang kita putus/hapus dari antrian

				if (prev == null) {
					// Kondisi 1: Yang dihapus adalah elemen paling depan (front)
					front = front.next;
					if (front == null) {
						rear = null; // Jika antrian menjadi kosong total
					}
				} else {
					// Kondisi 2: Yang dihapus ada di tengah atau di paling belakang
					prev.next = current.next;
					if (current.next == null) {
						rear = prev; // Jika yang dihapus adalah elemen terakhir (rear), pindahkan rear
					}
				}

				current.request.setStatus("Resolved");
				return current.request; // Kembalikan objek yang berhasil ditemukan dan dihapus
			}
			// Geser pointer ke node selanjutnya
			prev = current;
			current = current.next;
		}

		// Jika looping selesai tapi tidak ketemu
		System.out.println("[!] Laporan dengan ID '" + requestId + "' tidak ditemukan di sistem.");
		return null;
	}
	
	// --- Validasi ID Kembar ---
    public boolean isIdExist(String requestId) {
        QueueNode current = front;
        // Looping dari depan ke belakang
        while (current != null) {
            if (current.request.getRequestId().equalsIgnoreCase(requestId)) {
                return true; // ID sudah ada di antrian!
            }
            current = current.next;
        }
        return false; // ID aman (belum ada)
    }
}