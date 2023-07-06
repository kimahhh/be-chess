package softeer2nd.chess.pieces;

public class Pawn extends Piece {
    private Pawn(Color color) {
        super(color, Type.PAWN);
    }

    public static Pawn createWhitePawn() {
        return new Pawn(Color.WHITE);
    }
    public static Pawn createBlackPawn() {
        return new Pawn(Color.BLACK);
    }
}
