package tugas;

public class Main {

	public static void main(String[] args) {
		Mobil mobil = new Mobil("Toyota Avanza", 5);
		Motor motor = new Motor("Honda Beat", 2);
		Sepeda sepeda = new Sepeda("Polygon", 1);
		
		Kendaraan[] daftarKendaraan = {mobil, motor, sepeda};
		
		int jarak = 10;
		boolean promo = true;	
		
		for (Kendaraan k : daftarKendaraan) {
			k.informasi();
			System.out.println("Tarif untuk " + jarak + " km: Rp" + k.hitungTarif(jarak));
			System.out.println("Tarif dengan promo: Rp" + k.hitungTarif(jarak, promo));
			System.out.println();
		}
		
		

	}

}
