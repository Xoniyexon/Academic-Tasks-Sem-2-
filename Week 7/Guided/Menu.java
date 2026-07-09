package tugas;

public class Menu {
	    private String kode;
	    private String nama;
	    private double harga;

	    public Menu(String kode, String nama, double harga) {
	        this.kode = kode;
	        this.nama = nama;
	        this.harga = harga;
	    }

	    public String getKode() {
	        return kode;
	    }

	    public String getNama() {
	        return nama;
	    }

	    public double getHarga() {
	        return harga;
	    }

	    @Override
	    public String toString() {
	        return "Kode: " + kode + " | Nama: " + nama + " | Harga: Rp " + harga;
	    }
	}
