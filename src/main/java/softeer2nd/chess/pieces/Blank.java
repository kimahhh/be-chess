package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

public class Blank extends Piece {
    private Blank() {
        super(Color.NO_COLOR, Type.NO_PIECE);
    }

    public static Blank createBlank() {
        return new Blank();
    }

    @Override
    public boolean verifyMovePosition(Position sourcePosition, Position targetPosition) {
        return false;
    }
}
