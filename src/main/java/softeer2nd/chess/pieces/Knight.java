package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import static softeer2nd.chess.Direction.knightDirection;

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

    @Override
    public boolean verifyMovePosition(Position sourcePosition, Position targetPosition) {
        int dx = targetPosition.getX() - sourcePosition.getX();
        int dy = sourcePosition.getY() - targetPosition.getY();
        return knightDirection().stream()
                .anyMatch(direction -> direction.getXDegree() == dx && direction.getYDegree() == dy);
    }
}
