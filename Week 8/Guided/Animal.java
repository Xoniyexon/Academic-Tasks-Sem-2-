package tugas;

public class Animal {
	String name;
	int age;
	String species;
	
	public Animal(String name, int age, String species) {
		this.name = name;
		this.age = age;
		this.species = species;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + age + " years, " + species + "]";
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Animal animal = (Animal) obj;
		return name.equalsIgnoreCase(animal.name);
	}
}
