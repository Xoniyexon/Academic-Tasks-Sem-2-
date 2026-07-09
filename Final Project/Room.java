package project;

public class Room {
	private String roomNumber;
	private String roomType;
	private double pricePerMonth;

	public Room(String roomNumber, String roomType, double pricePerMonth) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.pricePerMonth = pricePerMonth;
	}

	// Encapsulation: Getter dan Setter
	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}
}