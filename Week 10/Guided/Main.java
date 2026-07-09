package tugas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TournamentQueue queue = new TournamentQueue();

        while (true) {
            System.out.println("1. Add Player");
            System.out.println("2. Remove Player");
            System.out.println("3. Display Players");
            System.out.println("4. Next Player");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Game: ");
                    String game = scanner.nextLine();
                    queue.addPlayer(id, name, game);
                    break;
                case 2:
                    System.out.print("Enter Player ID to Remove: ");
                    int removeId = scanner.nextInt();
                    queue.removePlayer(removeId);
                    break;
                case 3:
                    System.out.println("Tournament Players:");
                    queue.displayPlayers();
                    break;
                case 4:
                    queue.nextPlayer();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}