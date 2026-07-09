package tugas;

public class Playlist {
	Song head;
	Song tail;
	Song current;

	public Playlist() {
		this.head = null;
		this.tail = null;
		this.current = null;
	}

	public void addSong(String title, String artist) {
		Song newSong = new Song(title, artist);
		if (head == null) {
			head = newSong;
			tail = newSong;
			current = newSong;
		} else {
			tail.next = newSong;
			newSong.prev = tail;
			tail = newSong;
		}
		System.out.println("Lagu ditambahkan: " + title + " - " + artist);
	}

	public void removeSong(String title) {
		if (head == null) {
			System.out.println("Playlist kosong.");
			return;
		}

		Song temp = head;

		while (temp != null) {
			if (temp.title.equalsIgnoreCase(title)) {
				if (temp == head) {
					head = temp.next;
					if (head != null) {
						head.prev = null;
					} else {
						tail = null;
					}
				} else if (temp == tail) {
					tail = temp.prev;
					if (tail != null) {
						tail.next = null;
					}
				} else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}
				if (temp == current) {
					current = head;
				}

				System.out.println("Lagu telah dihapus: " + temp.title);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Lagu tidak ditemukan di playlist.");
	}

	public void playCurrent() {
		if (current != null) {
			System.out.println("Currently Playing: " + current.title + " - " + current.singer);
		} else {
			System.out.println("Tidak ada lagu di playlist.");
		}
	}

	public void playNext() {
		if (current != null && current.next != null) {
			current = current.next;
			System.out.println("Now Playing: " + current.title + " - " + current.singer);
		} else {
			System.out.println("Anda sudah berada di akhir playlist.");
		}
	}

	public void playPrevious() {
		if (current != null && current.prev != null) {
			current = current.prev;
			System.out.println("Now Playing: " + current.title + " - " + current.singer);
		} else {
			System.out.println("Anda sudah berada di awal playlist.");
		}
	}

	public void displayPlaylist() {
		if (head == null) {
			System.out.println("Playlist kosong.");
			return;
		}
		System.out.println("Playlist:");
		Song temp = head;
		while (temp != null) {
			System.out.println("- " + temp.title + " - " + temp.singer);
			temp = temp.next;
		}
	}
}
