package unguided;

public class Penguin {
	String name;
	String species;
	int age;
	double weight;
	
	public Penguin (String name, String species, int age, double weight) {
		this.name = name;
		this.species = species;
		this.age = age;
		this.weight = weight;
	}
	
	public void printPenguin() {
		System.out.println("Name : " + name);
		System.out.println("Species : " + species);
		System.out.println("Age : " + age + " years");
		System.out.println("Weight : " + weight + " kg");
	}

}
