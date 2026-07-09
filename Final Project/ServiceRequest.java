package project;

public abstract class ServiceRequest implements Billable {
	protected String requestId;
	protected String residentName;
	protected String status; // Pending, In Progress, Resolved

	public ServiceRequest(String requestId, String residentName) {
		this.requestId = requestId;
		this.residentName = residentName;
		this.status = "Pending";
	}

	// Encapsulation dasar
	public String getRequestId() {
		return requestId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getResidentName() {
		return residentName;
	}

	// Abstract methods untuk Polymorphism
	public abstract double calculateCost();

	public abstract void displayDetail();

	@Override
	public double getBillingAmount() {
		return calculateCost();
	}

	@Override
	public String getBillingDescription() {
		return "Tagihan Layanan Dormi (" + requestId + "): " + residentName;
	}
}