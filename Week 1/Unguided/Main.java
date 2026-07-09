package unguided;

public class Main {

	public static void main(String[] args) {
		// Create Penguin
		Penguin[] penguins = createPenguins();

		// Print before Add and Delete
		printPenguins(penguins);

		// Add Penguin
		Penguin newPenguin = new Penguin("Peach", "Macaroni", 3, 11.4);
		penguins = addPenguin(penguins, newPenguin);

		// Delete Penguin
		penguins = deletePenguin(penguins, "Paul");

		// Print after Add and Delete
		printPenguins(penguins);
	}

	public static Penguin[] createPenguins() {
		Penguin[] penguins = new Penguin[10];

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

	public static Penguin[] addPenguin(Penguin[] penguins, Penguin newPenguin) {
		for (int i = 0; i < penguins.length; i++) {
			if (penguins[i] == null) {
				penguins[i].name = newPenguin.name;
				penguins[i].species = newPenguin.species;
				penguins[i].age = newPenguin.age;
				penguins[i].weight = newPenguin.weight;
				System.out.println("New Penguin has been added.");
				break;
			} else {
				System.out.println("No slot left, cannot add new penguin.");
				break;
			}
		}
		return penguins;
	}

	public static Penguin[] deletePenguin(Penguin[] penguins, String name) {
		for (int i = 0; i < penguins.length; i++) {
			if (penguins[i] != null && penguins[i].name.equals(name)) {
				penguins[i] = null;
				System.out.println(name + " has been removed.");
				break;
			} else {
				System.out.println(name + " not found. Cannot be Removed.");
			}
		}
		return penguins;
	}
}
