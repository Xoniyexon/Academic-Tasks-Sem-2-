package Tugas;

public class PartTimeEmployee extends Employee {
	int hourlyRate;
	int workingHours;
	
	public PartTimeEmployee(String idNew, String fullNameNew, int salaryNew, int hourlyRateNew, int workingHoursNew) {
		super(idNew, fullNameNew, salaryNew);
		this.hourlyRate = hourlyRateNew;
		this.workingHours = workingHoursNew;
	}
}
