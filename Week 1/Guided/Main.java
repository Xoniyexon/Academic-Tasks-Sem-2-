package guided;

public class Main {

	public static void main(String[] args) {
		// Create Penguin
		Penguin[] penguins = createPenguins();

		// Print before Edit
		printPenguins(penguins);

		// Call Edit Function
		editPenguin(penguins, "Penny", 4, 16.0);

		// Print after Edit
		printPenguins(penguins);
	}

	public static Penguin[] createPenguins() {
		Penguin[] penguins = new Penguin[5];

		penguins[0] = new Penguin("Penny", "Emperor", 3, 15.5);
		penguins[1] = new Penguin("Peter", "King", 2, 12.3);
		penguins[2] = new Penguin("Paul", "Adelie", 4, 10.8);
		penguins[3] = new Penguin("Polly", "Chinstrap", 1, 8.2);
		penguins[4] = new Penguin("Piper", "Gentoo", 5, 13.6);

		return penguins;
	}

	public static void printPenguins(Penguin[] penguins) {
		for (int i = 0; i < penguins.length; i++) {
			penguins[i].printPenguin();
			System.out.println();
		}
	}

	public static void editPenguin(Penguin[] penguins, String name, int newAge, double newWeight) {
		for (int i = 0; i < penguins.length; i++) {
			if (penguins[i] != null && penguins[i].name.equals(name)) {
				penguins[i].age = newAge;
				penguins[i].weight = newWeight;
				System.out.println(name + " has been updated.");
			} 
		} 
	}
}
