package tugas;

import java.util.Scanner;

public class Museum {
    public static void main(String[] args) {
        Gallery gallery = new Gallery();
        ArtPiece piece;
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        int choice;

        String name;
        String type;
        String creator;
        int year;

        do {
            System.out.println("\n=== Art Museum ===");
            System.out.println("1. View gallery");
            System.out.println("2. Add an art piece");
            System.out.println("3. Remove an art piece");
            System.out.println("4. Exit museum");
            System.out.print("Enter Choice: ");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nViewing the gallery...");
                    int pick = 0;
                    do {
                        System.out.print("\nWhat to do? (1.Next Piece / 2. Leave): ");
                        pick = scan.nextInt();
                        scan.nextLine();
                        
                        switch (pick) {
                            case 1:
                                gallery.nextArt();
                                break;
                            case 2:
                                pick = 2;
                                break;
                            default:
                                System.out.println("Invalid Input. Please Try Again!");
                                break;
                        }
                    } while (pick != 2);
                    break;

                case 2:
                    System.out.print("Piece Name: ");
                    name = scan.nextLine();
                    System.out.print("Type: ");
                    type = scan.nextLine();
                    System.out.print("Creator: ");
                    creator = scan.nextLine();
                    System.out.print("Year: ");
                    year = scan.nextInt();
                    scan.nextLine();

                    piece = new ArtPiece(name, type, creator, year);
                    gallery.addPiece(piece);
                    break;

                case 3:
                    System.out.print("Enter Piece Name: ");
                    name = scan.nextLine();

                    gallery.deletePiece(name);
                    break;

                case 4:
                    System.out.println("Exiting museum...");
                    scan.close();
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid Input. Please Try Again!");
                    break;
            }
        } while (!exit);
    }
}