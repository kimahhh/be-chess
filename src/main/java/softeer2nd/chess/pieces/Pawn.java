package softeer2nd.chess.pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String WHITE_REPRESENTATION = "p";
    public static final String BLACK_REPRESENTATION = "P";

    private String color;
    private String representation;

    public Pawn() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(String color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return this.color;
    }
    public String getRepresentation() {
        return this.representation;
    }
}
