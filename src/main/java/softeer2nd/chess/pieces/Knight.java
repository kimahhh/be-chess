package softeer2nd.chess.pieces;

public class Knight extends Piece {
    private Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    public static Knight createWhiteKnight() {
        return new Knight(Color.WHITE);
    }
    public static Knight createBlackKnight() {
        return new Knight(Color.BLACK);
    }
}
