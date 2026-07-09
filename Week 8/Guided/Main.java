package tugas;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LinkedList<Animal> animalList = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("\n===== Animal Linked List Menu =====");
			System.out.println("1. Add Animal");
			System.out.println("2. Remove Animal");
			System.out.println("3. Search Animal");
			System.out.println("4. Display All Animals");
			System.out.println("5. Exit");
			System.out.println("Enter Choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1: 
				System.out.println("Enter name: ");
				String name = sc.nextLine();
				System.out.println("Enter age: ");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter species: ");
				String species = sc.nextLine();
				animalList.append(new Animal(name, age, species));
				break;
				
			case 2: 
				System.out.println("Enter name to remove: ");
				String removeName = sc.nextLine();
				animalList.deleteNode(new Animal(removeName, 0, ""));
				System.out.println(removeName + " has been removed.");
				break;
				
			case 3: 
				System.out.println("Enter name to search: ");
				String searchName = sc.nextLine();
				System.out.println(animalList.search(new Animal(searchName, 0, ""))
						? "Animal Found!" : "Animal not found.");
				break;				
				
			case 4: 
				animalList.display();
				break;
				
			case 5: 
				System.out.println("Exiting...");
				break;
				
			default : 
			System.out.println("Invalid Choice! Please enter a number between 1 and 5.");
			}
			
		} while (choice != 5);

	sc.close();
	}
}
