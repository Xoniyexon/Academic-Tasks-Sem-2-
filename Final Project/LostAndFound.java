package project;

public class LostAndFound extends ServiceRequest {
	private String itemName;
	private String lastSeenLocation;

	public LostAndFound(String requestId, String residentName, String itemName, String lastSeenLocation) {
		super(requestId, residentName);
		this.itemName = itemName;
		this.lastSeenLocation = lastSeenLocation;
	}

	@Override
	public double calculateCost() {
		return 0; // Pelaporan barang hilang gratis
	}

	@Override
	public void displayDetail() {
		System.out.println("[Lost & Found] ID: " + requestId + " | Pelapor: " + residentName + " | Barang: " + itemName
				+ " | Terakhir dilihat: " + lastSeenLocation + " | Status: " + status);
	}
}