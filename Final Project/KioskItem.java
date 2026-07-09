package project;

public class KioskItem implements Billable {
	private String residentName; // Menyimpan nama pembeli
	private String itemName;
	private double price;
	private int quantity;

	public KioskItem(String residentName, String itemName, double price, int quantity) {
		this.residentName = residentName;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getSubtotal() {
		return price * quantity;
	}

	@Override
	public String toString() {
		return itemName + " (x" + quantity + ") - Rp" + price + "/pcs | Subtotal: Rp" + getSubtotal();
	}

	@Override
	public double getBillingAmount() {
		return getSubtotal();
	}

	@Override
	public String getBillingDescription() {
		return "Pembelian Koperasi: " + getItemName() + " (x" + getQuantity() + ")";
	}

	@Override
	public String getResidentName() {
		return residentName;
	}
}