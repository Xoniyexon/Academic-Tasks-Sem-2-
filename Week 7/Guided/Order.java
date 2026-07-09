package tugas;

import java.util.Map;

public class Order {
	private static int counter = 1;
	private int orderNumber;
	private String customerName;
	private Map<String, Integer> items;
	private String status;
	private double totalPrice;

	public Order(String customerName, Map<String, Integer> items, double totalPrice) {
		this.orderNumber = counter++;
		this.customerName = customerName;
		this.items = items;
		this.status = "Pending";
		this.totalPrice = totalPrice;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Map<String, Integer> getItems() {
		return items;
	}

	public String getStatus() {
		return status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void processOrder() {
		this.status = "Processed";
	}

	@Override
	public String toString() {
		return "No. Pesanan: " + orderNumber + " | Nama: " + customerName + " | Items: " + items + " | Status: "
				+ status + " | Total Harga: Rp " + totalPrice;
	}
}
