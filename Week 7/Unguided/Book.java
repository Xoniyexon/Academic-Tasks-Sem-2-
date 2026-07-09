package tugas;

public class Book {
	private String id;
	private String title;
	private String author;
	private int year;
	private boolean isAvailable;
	
	public Book(String id, String title, String author, int year) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isAvailable = true;
	}
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean available) {
		this.isAvailable = available;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + " | Title: " + title + " | Author: " + author + " | Year: " + year + " | Available: " + (isAvailable ? "Yes" : "No");
	}
}
