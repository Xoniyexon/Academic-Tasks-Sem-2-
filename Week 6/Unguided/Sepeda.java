package tugas;

public class Sepeda extends Kendaraan {
	Sepeda(String nama, int kapasitasPenumpang) {
		super(nama, kapasitasPenumpang);
	}

	@Override
	void informasi() {
		System.out.println("Sepeda: " + nama + ", Kapasitas: " + kapasitasPenumpang + " penumpang");
	}

	@Override
	int hitungTarif(int jarak) {
		return 0;
	}

}
