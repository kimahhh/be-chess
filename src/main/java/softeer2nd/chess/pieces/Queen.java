package softeer2nd.chess.pieces;

public class Queen extends Piece {
    private Queen(Color color) {
        super(color, Type.QUEEN);
    }

    public static Queen createWhiteQueen() {
        return new Queen(Color.WHITE);
    }
    public static Queen createBlackQueen() {
        return new Queen(Color.BLACK);
    }
}
