package tugas;

import java.util.Scanner;

public class Backrooms {
	static class Node {
		Rooms data;
		Node next;
		Node prev;

		Node(Rooms rm) {
			data = rm;
			next = null;
			prev = null;
		}
	}

	private Node start;
	private Node end;

	public Backrooms() {
		Node current = start;
		String rType;
		String rName;
		String content;

		int size = randomNum(5, 10);
		for (int i = 0; i < size; i++) {
			int roomType = randomNum(1, 6);

			switch (roomType) {
			case 1:
				rType = "Empty";
				rName = "Empty Hallway";
				content = "It's all yellow...";
				break;

			case 2:
				rType = "Damaged";
				rName = "Damaged Hallway";
				content = "This room looks damaged...";
				break;

			case 3:
				rType = "Entity";
				rName = "Entity Hallway";
				content = "There is an entity in this room!";
				break;

			case 4:
				rType = "Dark";
				rName = "Dark Hallway";
				content = "It's too dark! I can't see anything...";
				break;

			default:
				rType = "Empty";
				rName = "Empty Hallway";
				content = "It's all yellow...";
				break;

			}
			Rooms room = new Rooms(rName, rType, content);
			Node newRoom = new Node(room);

			if (start == null) {
				start = newRoom;
			} else {
				current = start;

				while (current.next != null) {
					current = current.next;
				}
				current.next = newRoom;
				newRoom.prev = current;
			}
		}

		Node last = current.next;
		last.next = start;
		start.prev = last;

		current = start;

		int exitRoom = randomNum(1, size);
		for (int i = 0; i < exitRoom; i++) {
			current = current.next;
		}
		end = current;
	}

	public void startBackrooms() {
		Node current = start;
		boolean game = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("\nYou accidentally noclipped into the backrooms...");
		
		do {
			System.out.println("\nWhat is around you: ");
			System.out.println(current.data.roomName + "\n");
			System.out.println("On the left: ");
			System.out.println(current.next.data.roomName + "\n");
			System.out.println("On the right: ");
			System.out.println(current.prev.data.roomName + "\n");
			
			System.out.println("Where to Go?");
			System.out.println("1. Go Left");
			System.out.println("2. Go Right");
			System.out.println("3. Check the Area");
			System.out.println("Choose: ");
			int choice = Integer.parseInt(scan.nextLine());
			
			switch (choice) {
			case 1: 
				current = current.next;
				break;
				
			case 2: 
				current = current.prev;
				break;
				
			case 3:
				if (current == end) {
					System.out.println("Do you want to leave? (y/n)");
					String option = scan.nextLine();
					
					if (option.equalsIgnoreCase("y")) {
						System.out.println("Congrats! You leave the Backrooms!");
						game = false;
					} else {
						System.out.println("You chose to stay...");
					}
				} else {
					current.data.viewContent();
				}
				break;
				default: 
					System.out.println("Invalid Option! Try Again.");
					break;
			}
		} while (game == true);

	}

	public int randomNum(int min, int max) {
		int range = max - min + 1;

		int result = (int) (Math.random() * range) + min;
		return result;
	}

}
