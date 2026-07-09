package Tugas;

public abstract class TiketBioskop {
	protected String film;
	protected String studio;
	protected int jumlahTiket;
	protected double hargaPerTiket;

	public TiketBioskop(String film, String studio, int jumlahTiket, double hargaPerTiket) {
		this.film = film;
		this.studio = studio;
		this.jumlahTiket = jumlahTiket;
		this.hargaPerTiket = hargaPerTiket;
	}

	public abstract double hitungHargaTiket();

	protected abstract double hitungDiskon(double totalHarga);

	protected double getHargaPerTiket() {
		return hargaPerTiket;
	}

	public void tampilkanInfo() {
		double hargaSebelumDiskon = hitungHargaTiket();
		double diskon = hitungDiskon(hargaSebelumDiskon);
		double hargaSetelahDiskon = hargaSebelumDiskon - diskon;

		System.out.println("Film: " + film + " | Studio: " + studio + " | Tiket: " + jumlahTiket);
		System.out.println("Harga per tiket: Rp" + hargaPerTiket);
		System.out.println("Harga Sebelum Diskon: Rp" + hargaSebelumDiskon);
		System.out.println("Diskon: Rp" + diskon);
		System.out.println("Harga Setelah Diskon: Rp" + hargaSetelahDiskon);

	}

}
