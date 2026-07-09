package tugas;

public class Rooms {
	public String roomName;
	public String roomType;
	public String content;
	
	public Rooms(String name, String type, String content) {
		this.roomName = name;
		this.roomType = type;
		this.content = content;
	}
	
	public void viewContent() {
		System.out.println(content);
	}

}
