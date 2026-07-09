package tugas;
import java.util.Scanner;

public class TowerOfHanoi {
	static int moveCount = 0;

	public static void towerOfHanoi(int disks, StackLinkedList<Integer> source, StackLinkedList<Integer> auxiliary, StackLinkedList<Integer> destination, String sourceName, String auxiliaryName, String destinationName) {
		if (disks == 0) return;
		
		towerOfHanoi(disks - 1, source, destination, auxiliary, sourceName, destinationName, auxiliaryName);
		
		int disk = source.pop();
		destination.push(disk);
		System.out.println("Move disk " + disk + " from " + sourceName + " to " + destinationName);
		moveCount++;
		
		towerOfHanoi(disks - 1, auxiliary, source, destination, auxiliaryName, sourceName, destinationName);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int numDisks = scanner.nextInt();
		
		StackLinkedList<Integer> towerA = new StackLinkedList<>();
		StackLinkedList<Integer> towerB = new StackLinkedList<>();
		StackLinkedList<Integer> towerC = new StackLinkedList<>();
		
		for (int i = numDisks; i > 0; i--) {
			towerA.push(i);
		}
		
		towerOfHanoi(numDisks, towerA, towerB, towerC, "A", "B", "C");
		System.out.println("Total moves required: " + moveCount);
		scanner.close();
	}
	
}
