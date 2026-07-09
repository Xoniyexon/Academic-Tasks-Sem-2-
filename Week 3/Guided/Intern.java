package Tugas;

public class Intern extends PartTimeEmployee{
	String university;
	int internshipDuration;
	
	public Intern(String idNew, String fullNameNew, int salaryNew, int hourlyRateNew, int workingHoursNew, String universityNew, int internshipDurationNew) {
		super(idNew, fullNameNew, salaryNew, hourlyRateNew, workingHoursNew);
		this.university = universityNew;
		this.internshipDuration = internshipDurationNew;
	}

	@Override
	public int calculateSalary() {
		this.salary = salary + ((this.hourlyRate * this.workingHours) * 20);
		return salary;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("ID 			: " + id);
		System.out.println("Name 			: " + fullName);
		System.out.println("Position 		: Intern");
		System.out.printf("Salary 			: Rp%,d%n", salary);
		System.out.println("University 		: " + university);
		System.out.println("Internship Duration 	: " + internshipDuration + " Months");
	}
}
