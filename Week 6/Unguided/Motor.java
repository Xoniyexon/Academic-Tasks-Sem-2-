package tugas;

public class Motor extends Kendaraan {
	private static final int TARIF_PER_KM = 3000;

	Motor(String nama, int kapasitasPenumpang) {
		super(nama, kapasitasPenumpang);
	}

	@Override
	void informasi() {
		System.out.println("Motor: " + nama + ", Kapasitas: " + kapasitasPenumpang + " penumpang");
	}

	@Override
	int hitungTarif(int jarak) {
		return jarak * TARIF_PER_KM;
	}

}
