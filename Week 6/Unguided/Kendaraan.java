package tugas;

abstract class Kendaraan {
	String nama;
	int kapasitasPenumpang;

	Kendaraan(String nama, int kapasitasPenumpang) {
		this.nama = nama;
		this.kapasitasPenumpang = kapasitasPenumpang;
	}
	
	abstract void informasi();
	
	abstract int hitungTarif(int jarak);
	
	// Method Overloading dengan diskon promo
	int hitungTarif(int jarak, boolean promo) {
		int tarif = hitungTarif(jarak);
	return promo? (int) (tarif * 0.80) : tarif;
	}
}
