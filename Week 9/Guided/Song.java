package tugas;

public class Song {
	String title;
	String singer;
	
	Song prev;
	Song next;
	
	public Song(String title, String singer) {
		this.title = title;
		this.singer = singer;
		this.prev = null;
		this.next = null;	
	}
}
