package tugas;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int choice = 0;
		
		do {
			System.out.println("======= Blaze's Backroom Game =======");
			System.out.println("1. Start");
			System.out.println("2. Exit");
			System.out.println("Choose: ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				Backrooms backrooms = new Backrooms();
				backrooms.startBackrooms();
				break;
				
			case 2: 
				System.out.println("Thank you for Playing!");
				break;
			
			default: 
				System.out.println("Please Input a Valid Number!");
				break;
			}
			System.out.println("");
		} while (choice != 2);
		sc.close();
	}
}
