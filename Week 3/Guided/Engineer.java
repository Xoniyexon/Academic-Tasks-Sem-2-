package Tugas;

public class Engineer extends FullTimeEmployee {
	String specialization;
	
	public Engineer (String idNew, String fullNameNew, int salaryNew, int annualBonusNew, String specializationNew) {
		super(idNew, fullNameNew, salaryNew, annualBonusNew);
		this.specialization = specializationNew;
	}

	@Override
	public int calculateSalary() {
		this.salary = salary + (this.annualBonus/12);
		return salary;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("ID 			: " + id);
		System.out.println("Name 			: " + fullName);
		System.out.println("Position 		: Engineer");
		System.out.printf("Salary 			: Rp%,d%n", salary);
		System.out.println("Specialization 		: " + specialization);
		
	}
}
