package tugas;

public class TournamentQueue {
    private Player head = null;
    private Player tail = null;
    private Player current = null;

    public void addPlayer(int id, String name, String game) {
        Player newPlayer = new Player(id, name, game);
        
        if (head == null) {
            head = newPlayer;
            tail = newPlayer;
            newPlayer.next = head; 
            current = head;   
        } else {
            tail.next = newPlayer;
            tail = newPlayer;
            tail.next = head;     
        }
    }

    public void removePlayer(int id) {
        if (head == null) return;

        Player temp = head;
        Player prev = tail;

        if (head.id == id && head == tail) {
            head = null;
            tail = null;
            current = null;
            return;
        }

        do {
            if (temp.id == id) {
                prev.next = temp.next;
                if (temp == head) {
                    head = temp.next;
                    tail.next = head;
                }
                if (temp == tail) {
                    tail = prev;
                }
                if (temp == current) {
                    current = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void nextPlayer() {
        if (current != null) {
            System.out.println("Next Player: " + current.name);
            System.out.println(current.game);
            current = current.next;
        }
    }

    public void displayPlayers() {
        if (head == null) {
            return;
        }
        Player temp = head;
        do {
            System.out.println(temp.id + ": " + temp.name + " - " + temp.game);
            temp = temp.next;
        } while (temp != head);
    }
}
