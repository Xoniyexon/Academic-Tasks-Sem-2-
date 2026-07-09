package tugas;
import java.util.*;

public class RestaurantManager {
    private Map<String, Menu> menuList;
    private List<Order> orders;
    private List<Member> vipCustomers;

    public RestaurantManager() {
        this.menuList = new HashMap<>();
        this.orders = new LinkedList<>();
        this.vipCustomers = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        menuList.put(menu.getKode(), menu);
    }

    public void displayMenu() {
        System.out.println("\n=== Daftar Menu ===");
        for (Menu menu : menuList.values()) {
            System.out.println(menu);
        }
    }
    public void placeOrder(String customerName, Map<String, Integer> items) {
        double totalPrice = 0.0;

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String kode = entry.getKey();
            int quantity = entry.getValue();

            if (!menuList.containsKey(kode)) {
                System.out.println("Kode menu " + kode + " tidak ditemukan!");
                return;
            }

            totalPrice += menuList.get(kode).getHarga() * quantity;
        }

        Order order = new Order(customerName, items, totalPrice);
        orders.add(order);
        System.out.println("Pesanan berhasil ditambahkan: " + order);
    }

    public void processOrder() {
        if (orders.isEmpty()) {
            System.out.println("Tidak ada pesanan yang menunggu.");
            return;
        }

        Order order = orders.remove(0);
        order.processOrder();
        System.out.println("Memproses pesanan: " + order);
    }

    public void displayPendingOrders() {
        if (orders.isEmpty()) {
            System.out.println("Tidak ada pesanan yang menunggu.");
        } else {
            System.out.println("\n=== Pesanan dalam Antrian ===");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    public void addVipCustomer(Member member) {
        if (vipCustomers.contains(member)) {
            System.out.println("Pelanggan ini sudah menjadi VIP.");
        } else {
            vipCustomers.add(member);
            System.out.println("Pelanggan " + member.getName() + " ditambahkan ke daftar VIP.");
        }
    }

    public void displayVipCustomers() {
        if (vipCustomers.isEmpty()) {
            System.out.println("Belum ada pelanggan VIP yang terdaftar.");
        } else {
            System.out.println("\n=== Daftar Pelanggan VIP ===");
            for (Member member : vipCustomers) {
                System.out.println(member);
            }
        }
    }
}

