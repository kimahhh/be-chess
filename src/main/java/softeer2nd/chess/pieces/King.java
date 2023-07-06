package softeer2nd.chess.pieces;

public class King extends Piece{
    private King(Color color) {
        super(color, Type.KING);
    }

    public static King createWhiteKing() {
        return new King(Color.WHITE);
    }
    public static King createBlackKing() {
        return new King(Color.BLACK);
    }
}
