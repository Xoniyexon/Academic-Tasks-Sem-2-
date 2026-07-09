package project;

public class CleaningRequest extends ServiceRequest {
	private String cleaningType; // Full, Toilet

	public CleaningRequest(String requestId, String residentName, String cleaningType) {
		super(requestId, residentName);
		this.cleaningType = cleaningType;
	}

	@Override
	public double calculateCost() {
		if (cleaningType.equalsIgnoreCase("Full"))
			return 50000;
		else if (cleaningType.equalsIgnoreCase("Toilet"))
			return 25000;
		return 0;
	}

	@Override
	public void displayDetail() {
		System.out.println("[Cleaning] ID: " + requestId + " | Oleh: " + residentName + " | Paket: " + cleaningType
				+ " | Biaya: Rp" + calculateCost() + " | Status: " + status);
	}
}
