package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import java.util.List;

import static softeer2nd.exception.Exception.BLANK_CANT_MOVE;
import static softeer2nd.exception.Exception.PIECE_INVALID_PATH;

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

    @Override
    public List<Position> verifyPathClear(Position sourcePosition, Position targetPosition) {
        throw new IllegalArgumentException(PIECE_INVALID_PATH.getMessage());
    }
}
