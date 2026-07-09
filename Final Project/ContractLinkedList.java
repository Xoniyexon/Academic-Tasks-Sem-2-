package project;

//Node untuk menyimpan data Kontrak dan pointer dua arah (prev & next)
class Node {
	Contract contract;
	Node prev;
	Node next;

	public Node(Contract contract) {
		this.contract = contract;
		this.prev = null;
		this.next = null;
	}
}

public class ContractLinkedList {
	private Node head;
	private Node tail;

	public ContractLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// [C]REATE: Menambahkan kontrak baru di akhir list
	public boolean addContract(Contract contract) {
		// VALIDASI: Cari apakah ID kontrak sudah ada di dalam list
		if (findNode(contract.getContractId()) != null) {
			return false; // Kembalikan false jika ID sudah kembar/duplikat
		}

		Node newNode = new Node(contract);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		return true;
	}

	// [R]EAD: Menampilkan semua kontrak dari head ke tail
	public void displayAllContracts() {
		if (head == null) {
			System.out.println("[Info] Belum ada data kontrak terdaftar.");
			return;
		}
		System.out.println("\n--- DAFTAR SELURUH KONTRAK (DOUBLY LINKED LIST) ---");
		Node current = head;
		while (current != null) {
			System.out.println(current.contract);
			current = current.next;
		}
	}

	// Helper: Mencari node kontrak berdasarkan ID
	public Node findNode(String contractId) {
		Node current = head;
		while (current != null) {
			if (current.contract.getContractId().equalsIgnoreCase(contractId)) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	// [U]PDATE: Memperbarui durasi dan nama pada kontrak
	public boolean updateContract(String contractId, String newName, int newDuration) {
		Node target = findNode(contractId);
		if (target != null) {
			target.contract.setResidentName(newName);
			target.contract.setDurationMonths(newDuration);
			target.contract.setStatus("Updated/Extended");
			return true;
		}
		return false;
	}

	// [D]ELETE: Menghapus kontrak berdasarkan ID (Penanganan pointer ganda)
	public boolean deleteContract(String contractId) {
		Node target = findNode(contractId);
		if (target == null)
			return false;

		// Jika hanya ada 1 elemen di list
		if (target == head && target == tail) {
			head = tail = null;
		}
		// Jika yang dihapus adalah elemen pertama (head)
		else if (target == head) {
			head = head.next;
			head.prev = null;
		}
		// Jika yang dihapus adalah elemen terakhir (tail)
		else if (target == tail) {
			tail = tail.prev;
			tail.next = null;
		}
		// Jika berada di tengah-tengah
		else {
			target.prev.next = target.next;
			target.next.prev = target.prev;
		}
		return true;
	}

	public Node findNodeByRoomNumber(String roomNumber) {
		Node current = head;
		while (current != null) {
			// Mengakses objek room di dalam kontrak, lalu mencocokkan nomor kamarnya
			if (current.contract.getRoom().getRoomNumber().equalsIgnoreCase(roomNumber)) {
				return current; // Kamar ditemukan (sudah ada yang punya)
			}
			current = current.next;
		}
		return null; // Kamar kosong / belum ada yang menempati
	}
	
	public boolean isResidentExist(String residentName) {
		Node current = head;
		while (current != null) {
			if (current.contract.getResidentName().equalsIgnoreCase(residentName)) {
				return true; // Dia memang penghuni Oemah-ku
			}
			current = current.next;
		}
		return false; // Bukan penghuni
	}
	
	public Contract findContractByResidentName(String residentName) {
		Node current = head;
		while (current != null) {
			if (current.contract.getResidentName().equalsIgnoreCase(residentName)) {
				return current.contract;
			}
			current = current.next;
		}
		return null;
	}
	
}