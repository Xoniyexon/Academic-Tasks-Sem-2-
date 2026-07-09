package Tugas;

public class TiketReguler extends TiketBioskop {
	public TiketReguler(String film, String studio, int jumlahTiket, double hargaPerTiket) {
		super(film, studio, jumlahTiket, hargaPerTiket);
	}

	@Override
	public double hitungHargaTiket() {
		return jumlahTiket * hargaPerTiket;
	}
	
	@Override
	protected double hitungDiskon(double totalHarga) {
		if (jumlahTiket > 5) {
			return totalHarga * 0.05;
		}
		return 0;
	}
}
