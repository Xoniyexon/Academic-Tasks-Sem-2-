package tugas;

public class Player {
    int id;     
    String name;   
    String game;    

    Player next;     

    public Player(int id, String name, String game) {
        this.id = id;
        this.name = name;
        this.game = game;
        this.next = null;
    }
}