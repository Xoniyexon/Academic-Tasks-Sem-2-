package Tugas;

public class Admin extends PartTimeEmployee {
	String schedule;
	public Admin(String idNew, String fullNameNew, int salaryNew, int hourlyRateNew, int workingHoursNew, String scheduleNew) {
		super(idNew, fullNameNew, salaryNew, hourlyRateNew, workingHoursNew);
		this.schedule = scheduleNew;
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
		System.out.println("Position 		: Admin");
		System.out.printf("Salary 			: Rp%,d%n", salary);
		System.out.println("Schedule 		: " + schedule);
			
		
		
	}
}
