package tugas;

public class FitnessApp {
	private String userName;
	private double userWeight;
	private int userAge;
	private String dietPlan;
	private String exerciseRoutine;

	public FitnessApp(String userName, double userWeight, int userAge) {
		this.userName = userName;
		this.userWeight = userWeight;
		this.userAge = userAge;
		this.dietPlan = "Not Assigned";
		this.exerciseRoutine = "Not Assigned";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(double userWeight) {
		if (userWeight < 0) {
			System.out.println("Weight must greater than zero!");
		} else {
			this.userWeight = userWeight;
		}
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		if (userAge >= 0) {
			this.userAge = userAge;
		} else {
			System.out.println("Age can't be negative!");
		}
	}

	// Method to update weight
	public void updateWeight(double newWeight) {
		userWeight = newWeight;
		System.out.println(userName + "'s weight updated to: " + userWeight + " kg");
	}

	// Method to suggest a diet plan
	public void suggestDiet() {
		if (userWeight < 50) {
			dietPlan = "High Protein and High Calorie Diet";
		} else if (userWeight >= 50 && userWeight <= 80) {
			dietPlan = "Balanced Diet with Proteins, Carbs, and Fats";
		} else {
			dietPlan = "Low Carb & High Fiber Diet";
		}
		System.out.println(userName + "'s Suggested Diet Plan: " + dietPlan);
	}

	// Method to generate workout plan
	public void generateWorkoutPlan() {
		if (userWeight < 50) {
			exerciseRoutine = "Strength Training & Muscle Gain Workouts";
		} else if (userWeight >= 50 && userWeight <= 80) {
			exerciseRoutine = "Cardio & Weight Training (Balanced)";
		} else {
			exerciseRoutine = "High-Intensity Interval Training (HIIT) & Fat Burn Workouts";
		}
		System.out.println(userName + "'s Suggested Workout Plan: " + exerciseRoutine);
	}
}
