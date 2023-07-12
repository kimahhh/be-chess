package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import java.util.stream.IntStream;

import static softeer2nd.chess.Direction.diagonalDirection;

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

    @Override
    public boolean verifyMovePosition(Position sourcePosition, Position targetPosition) {
        int dx = targetPosition.getX() - sourcePosition.getX();
        int dy = sourcePosition.getY() - targetPosition.getY();
        for (int i : IntStream.range(1, 9).toArray()) {
            boolean match = diagonalDirection().stream()
                    .anyMatch(direction -> direction.getXDegree() * i == dx && direction.getYDegree() * i == dy);
            if (match) return true;
        }
        return false;
    }
}
