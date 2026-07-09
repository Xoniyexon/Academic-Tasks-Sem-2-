package Tugas;

import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();
		
		employees.add(new Manager("M001", "Budi Santoso", 10000000, 5000000, 10));
		employees.add(new HR("H001", "Edgar Eliezer", 8000000, 3000000, 10, "-"));
		employees.add(new Engineer("E001", "Andy Sutomo", 6000000, 3000000, "Data Analysis"));
		employees.add(new Engineer("E002", "Arya Desta", 6000000, 3000000, "Machine Learning"));
		
		employees.add(new Admin("A001", "Antonius Manyu", 500000, 30000, 8, "Monday-Friday"));
		employees.add(new Admin("A002", "Alexander Jody", 500000, 30000, 8, "Monday-Friday"));
		employees.add(new Salesperson("S001", "Yung Rivan", 1000000, 10000, 8, 10, 300000));
		employees.add(new Salesperson("S002", "Marcello Setiawan", 1000000, 10000, 8, 10, 300000));
		employees.add(new Intern("I001", "Christiano Zebula", 0, 30000, 6, "Universitas Multimedia Nusantara", 12));
		
		Manager manager = (Manager) employees.get(0);
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).fullName == manager.fullName) {
				continue;
			} else {
				manager.teamMember.add(employees.get(i));
			}
		}
		
		for (int i = 0; i < employees.size(); i++) {
			employees.get(i).calculateSalary();
			employees.get(i).displayInfo();
			System.out.println();
		}
	}
	

}
