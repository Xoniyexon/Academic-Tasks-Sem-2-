package Tugas;

public class FullTimeEmployee extends Employee {
	int annualBonus;
	
	public FullTimeEmployee(String idNew, String fullNameNew, int salaryNew, int annualBonusNew) {
		super(idNew, fullNameNew, salaryNew);
		this.annualBonus = annualBonusNew;
	}
}
