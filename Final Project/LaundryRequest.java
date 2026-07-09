package project;

public class LaundryRequest extends ServiceRequest {
	private double weightKg;
	private final double PRICE_PER_KG = 10000;

	public LaundryRequest(String requestId, String residentName, double weightKg) {
		super(requestId, residentName);
		this.weightKg = weightKg;
	}

	@Override
	public double calculateCost() {
		return weightKg * PRICE_PER_KG;
	}

	@Override
	public void displayDetail() {
		String formattedCost = String.format("%,.0f", calculateCost());

		System.out.println("[Laundry] ID: " + requestId + " | Oleh: " + residentName + " | Berat: " + weightKg
				+ " Kg | Biaya: Rp" + formattedCost + " | Status: " + status);
	}

}