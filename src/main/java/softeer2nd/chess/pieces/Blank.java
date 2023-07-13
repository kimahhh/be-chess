package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import static softeer2nd.exception.Exception.BLANK_CANT_MOVE;

public class Blank extends Piece {
    private Blank() {
        super(Color.NO_COLOR, Type.NO_PIECE);
    }

    public static Blank createBlank() {
        return new Blank();
    }

    @Override
    public boolean verifyMovePosition(Position sourcePosition, Position targetPosition) {
        throw new IllegalArgumentException(BLANK_CANT_MOVE.getMessage());
    }
}
