package softeer2nd.chess.pieces;

public class Rook extends Piece {
    private Rook(Color color) {
        super(color, Type.ROOK);
    }

    public static Rook createWhiteRook() {
        return new Rook(Color.WHITE);
    }
    public static Rook createBlackRook() {
        return new Rook(Color.BLACK);
    }
}
