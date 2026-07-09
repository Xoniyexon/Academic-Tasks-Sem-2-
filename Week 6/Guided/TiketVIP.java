package Tugas;

public class TiketVIP extends TiketBioskop {
	private boolean includeSnack;
	private double hargaSnack = 20000;

	public TiketVIP(String film, String studio, int jumlahTiket, double hargaPerTiket, boolean includeSnack) {
		super(film, studio, jumlahTiket, hargaPerTiket);
		this.includeSnack = includeSnack;
	}

	@Override
	public double hitungHargaTiket() {
		double total = jumlahTiket * hargaPerTiket;
		if (includeSnack) {
			total += jumlahTiket * hargaSnack;
		}
		return total;
	}

	@Override
	protected double hitungDiskon(double totalHarga) {
		if (jumlahTiket > 3) {
			return totalHarga * 0.10;
		}
		return 0;
	}

	@Override
	protected double getHargaPerTiket() {
		if (includeSnack) {
			return hargaPerTiket + hargaSnack;
		}
		return hargaPerTiket;
	}
}
