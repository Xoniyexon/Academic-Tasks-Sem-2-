package tugas;

public class Mobil extends Kendaraan {
	private static final int TARIF_PER_KM = 5000;

	Mobil(String nama, int kapasitasPenumpang) {
		super(nama, kapasitasPenumpang);
	}

	@Override
	void informasi() {
		System.out.println("Mobil: " + nama + ", Kapasitas: " + kapasitasPenumpang + " penumpang");
	}

	@Override
	int hitungTarif(int jarak) {
		return jarak * TARIF_PER_KM;
	}

}
