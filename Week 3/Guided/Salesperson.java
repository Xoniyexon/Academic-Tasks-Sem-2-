package Tugas;

public class Salesperson extends PartTimeEmployee{
	int salesTarget;
	int comissionRate;
	int clientsHandled;
	
	public Salesperson(String idNew, String fullNameNew, int salaryNew, int hourlyRateNew, int workingHoursNew, int salesTargetNew, int comissionRateNew) {
		super(idNew, fullNameNew, salaryNew, hourlyRateNew, workingHoursNew);
		this.salesTarget = salesTargetNew;
		this.comissionRate = comissionRateNew;
		this.clientsHandled = 0;
	}
	
	@Override
	public int calculateSalary() {
		this.salary = salary + ((this.hourlyRate * this.workingHours)* 20) + (this.comissionRate * this.clientsHandled);
		return salary;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("ID 			: " + id);
		System.out.println("Name 			: " + fullName);
		System.out.println("Position 		: Salesperson");
		System.out.printf("Salary 			: Rp%,d%n", salary);
		System.out.println("Sales Target 		: " + salesTarget);
		System.out.printf("Comission Rate 		: Rp%,d%s%n", comissionRate, " per sale");
		System.out.println("Sales Made 		: " + clientsHandled);
	}

}
