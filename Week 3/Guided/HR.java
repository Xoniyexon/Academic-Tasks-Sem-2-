package Tugas;

public class HR extends FullTimeEmployee {
	int recruitmentQuota;
	String trainingPrograms;
	
	public HR(String idNew, String fullNameNew, int salaryNew, int annualBonusNew, int recruitmentQuotaNew, String trainingProgramsNew) {
		super(idNew, fullNameNew, salaryNew, annualBonusNew);
		this.recruitmentQuota = recruitmentQuotaNew;
		this.trainingPrograms = trainingProgramsNew;
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
		System.out.println("Position			: HR");
		System.out.printf("Salary			: Rp%,d%n", salary);
		System.out.println("Recruitment Quota 	: " + recruitmentQuota);
		System.out.println("Training Programs 	: " + trainingPrograms);
	}
}
