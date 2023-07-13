package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import static softeer2nd.chess.Direction.blackPawnDirection;
import static softeer2nd.chess.Direction.whitePawnDirection;
import static softeer2nd.exception.Exception.PIECE_INVALID_COLOR;

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

    @Override
    public boolean verifyMovePosition(Position sourcePosition, Position targetPosition) {
        int dx = targetPosition.getX() - sourcePosition.getX();
        int dy = sourcePosition.getY() - targetPosition.getY();
        switch (this.getColor()) {
            case WHITE:
                return whitePawnDirection().stream()
                        .anyMatch(direction -> direction.getXDegree() == dx && direction.getYDegree() == dy);
            case BLACK:
                return blackPawnDirection().stream()
                        .anyMatch(direction -> direction.getXDegree() == dx && direction.getYDegree() == dy);
            default:
                throw new IllegalArgumentException(PIECE_INVALID_COLOR.getMessage());
        }
    }
}
