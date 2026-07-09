package Tugas;

public class TiketPremiere extends TiketBioskop {
	private boolean includeDinner;
	private double hargaDinner = 50000;

	public TiketPremiere(String film, String studio, int jumlahTiket, double hargaPerTiket, boolean includeDinner) {
		super(film, studio, jumlahTiket, hargaPerTiket);
		this.includeDinner = includeDinner;
	}

	@Override
	public double hitungHargaTiket() {
		double total = jumlahTiket * hargaPerTiket;
		if (includeDinner) {
			total += jumlahTiket * hargaDinner;
		}
		return total;
	}

	@Override
	protected double hitungDiskon(double totalHarga) {
		if (jumlahTiket > 2) {
			return totalHarga * 0.15;
		}
		return 0;
	}

	@Override
	protected double getHargaPerTiket() {
		if (includeDinner) {
			return hargaPerTiket + hargaDinner;
		}
		return hargaPerTiket;
	}
}
