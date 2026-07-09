package Tugas;

public class Employee {
	String id;
	String fullName;
	int salary;

	public Employee(String idNew, String fullNameNew, int salaryNew) {
		this.id = idNew;
		this.fullName = fullNameNew;
		this.salary = salaryNew;
	}
	
	public void displayInfo() {
		System.out.println("ID : " + id);
		System.out.println("Name : " + fullName);
		System.out.println("Salary : " + salary);
	}
	
	public int calculateSalary() {
		return salary;
	}
}
