package tugas;

public class ArtPiece {
    private String name;
    private String type;
    private String creator;
    private int year;

    public ArtPiece(String name, String type, String creator, int year) {
        this.name = name;
        this.type = type;
        this.creator = creator;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String describePiece() {
        String artPiece = "\"" + name + "\" a " + type + " by " + creator + " " + year;
        return artPiece;
    }
}