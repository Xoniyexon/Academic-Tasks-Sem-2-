package tugas;

public class Main {
	public static void main(String[] args) {
		// Creating an array of FitnessApp objects
		FitnessApp[] users = new FitnessApp[3];
		users[0] = new FitnessApp("Samuel", 75, 30);
		users[1] = new FitnessApp("Alice", 55, 28);
		users[2] = new FitnessApp("John", 90, 35);
		
		// Using a traditional for loop to iterate through the array
		for(int i = 0; i < users.length; i++) {
			System.out.println("\nUser: " + users[i].getUserName());
			users[i].updateWeight(users[i].getUserWeight() + 3);// Simulating weight change
			users[i].suggestDiet();
			users[i].generateWorkoutPlan();
		}
		
	}

}
