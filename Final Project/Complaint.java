package project;

public class Complaint extends ServiceRequest {
	private String category;
	private String description;

	public Complaint(String requestId, String residentName, String category, String description) {
		super(requestId, residentName);
		this.category = category;
		this.description = description;
	}

	@Override
	public double calculateCost() {
		return 0; // Komplain fasilitas tidak dipungut biaya
	}

	@Override
	public void displayDetail() {
		System.out.println("[Komplain] ID: " + requestId + " | Oleh: " + residentName + " | Kategori: " + category
				+ " | Keluhan: " + description + " | Status: " + status);
	}
}