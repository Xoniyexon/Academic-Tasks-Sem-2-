package project;

public class Contract implements Billable {
	private String contractId;
	private String residentName;
	private Room room;
	private int durationMonths;
	private String status;
	private CartStack cartStack = new CartStack();

	public Contract(String contractId, String residentName, Room room, int durationMonths) {
		this.contractId = contractId;
		this.residentName = residentName;
		this.room = room;
		this.durationMonths = durationMonths;
		this.status = "Active";
	}

	public CartStack getCartStack() {
		return cartStack;
	}

	// Getter dan Setter
	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getResidentName() {
		return residentName;
	}

	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getDurationMonths() {
		return durationMonths;
	}

	public void setDurationMonths(int durationMonths) {
		this.durationMonths = durationMonths;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalCost() {
		return room.getPricePerMonth() * durationMonths;
	}

	@Override
	public String toString() {
		// Menggunakan %,.0f untuk membulatkan double tanpa koma desimal
		// (titik/koma)
		String formattedCost = String.format("%,.0f", getTotalCost());

		return "ID: " + contractId + " | Nama: " + residentName + " | Kamar: " + room.getRoomNumber() + " ("
				+ room.getRoomType() + ")" + " | Durasi: " + durationMonths + " Bulan" + " | Total Biaya: Rp"
				+ formattedCost + " | Status: " + status;
	}

	@Override
	public double getBillingAmount() {
		return getTotalCost();
	}

	@Override
	public String getBillingDescription() {
		return "Tagihan Sewa Kamar " + getRoom().getRoomNumber() + " a/n " + getResidentName();
	}
}