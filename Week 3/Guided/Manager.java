package Tugas;

import java.util.ArrayList;

public class Manager extends FullTimeEmployee {
	int teamSize;
	ArrayList<Employee> teamMember;
	
	public Manager(String idNew, String fullNameNew, int salaryNew, int annualBonusNew, int teamSizeNew) {
		super(idNew, fullNameNew, salaryNew, annualBonusNew);
		this.teamSize = teamSizeNew;
		this.teamMember = new ArrayList<>();
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
		System.out.println("Position 		: Manager");
		System.out.printf("Salary 			: Rp%,d%n", salary);
		System.out.println("Team Member 		:");
		for(int i = 0; i < teamMember.size(); i++) {
			System.out.println("   - " + teamMember.get(i).fullName);
		}
	}
}
