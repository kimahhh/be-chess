package softeer2nd.chess.pieces;

public class Bishop extends Piece {
    private Bishop(Color color) {
        super(color, Type.BISHOP);
    }

    public static Bishop createWhiteBishop() {
        return new Bishop(Color.WHITE);
    }
    public static Bishop createBlackBishop() {
        return new Bishop(Color.BLACK);
    }
}
