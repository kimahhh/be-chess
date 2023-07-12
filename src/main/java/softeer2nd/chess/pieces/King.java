package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import static softeer2nd.chess.Direction.everyDirection;

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

    @Override
    public boolean verifyMovePosition(Position sourcePosition, Position targetPosition) {
        int dx = targetPosition.getX() - sourcePosition.getX();
        int dy = sourcePosition.getY() - targetPosition.getY();
        return everyDirection().stream()
                .anyMatch(direction -> direction.getXDegree() == dx && direction.getYDegree() == dy);
    }
}
