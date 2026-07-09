package tugas;

import java.util.Scanner;

public class Table {
	public static void main(String[] args) {
		Deck deck = new Deck();
		Card card;
		Scanner scan = new Scanner(System.in);

		boolean exit = false;
		int choice;
		String type;
		String value;

		do {
			System.out.println("\n======= Blaze's Card Table =======");
			System.out.println("1. Add Card to Deck");
			System.out.println("2. Remove Card from Deck");
			System.out.println("3. View Deck");
			System.out.println("4. Exit");
			System.out.println("Enter Choice: ");
			choice = Integer.parseInt(scan.nextLine());

			switch (choice) {
			case 1:
				boolean typeValid = false;
				do {
					System.out.println("Card Type (Spade, Heart, Clover, Diamond): ");
					type = scan.nextLine();
					if (type.equalsIgnoreCase("Spade") || type.equalsIgnoreCase("Hearts")
							|| type.equalsIgnoreCase("Clover") || type.equalsIgnoreCase("Diamond")) {
						typeValid = true;
					} else {
						System.out.println("Invalid Type! Please enter Spade, Hearts, Clover, or Diamond.");
					}
				} while (!typeValid);

				boolean valueValid = false;
				do {
					System.out.println("Value (A, 2-10, J, Q, K): ");
					value = scan.nextLine();
					if (value.equals("A") || value.equals("2") || value.equals("3") || value.equals("4")
							|| value.equals("5") || value.equals("6") || value.equals("7") || value.equals("8")
							|| value.equals("9") || value.equals("10") || value.equals("J") || value.equals("Q")
							|| value.equals("K")) {
						valueValid = true;
					} else {
						System.out.println("Invalid Value! Please enter a valid card value.");
					}
				} while (!valueValid);
				card = new Card(type, value);
				deck.addCard(card);
				break;

			case 2:
				System.out.println("Card Type (Spade, Heart, Clover, Diamond): ");
				type = scan.nextLine();
				System.out.println("Value (A, 2-10, J, Q, K): ");
				value = scan.nextLine();

				deck.removeCard(type, value);
				break;

			case 3:
				int selection = 0;
				do {
					System.out.println("\nAction ( 1.Next / 2.Previous / 3.Leave ): ");
					selection = Integer.parseInt(scan.nextLine());
					System.out.println("Current Card: ");

					switch (selection) {
					case 1:
						deck.moveNext();
						break;
					case 2:
						deck.movePrev();
						break;
					case 3:
						selection = 3;
						break;
					default:
						System.out.println("Invalid Input. Please Try Again!");
						break;
					}
				} while (selection != 3);
				break;

			case 4:
				scan.close();
				exit = true;
				break;

			default:
				System.out.println("Invalid Input. Please Try Again!");
				break;
			}
		} while (exit == false);
	}

}
