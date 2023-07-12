package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import java.util.stream.IntStream;

import static softeer2nd.chess.Direction.everyDirection;

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

    @Override
    public boolean verifyMovePosition(Position sourcePosition, Position targetPosition) {
        int dx = targetPosition.getX() - sourcePosition.getX();
        int dy = sourcePosition.getY() - targetPosition.getY();
        for (int i : IntStream.range(1, 9).toArray()) {
            boolean match = everyDirection().stream()
                    .anyMatch(direction -> direction.getXDegree() * i == dx && direction.getYDegree() * i == dy);
            if (match) return true;
        }
        return false;
    }
}
