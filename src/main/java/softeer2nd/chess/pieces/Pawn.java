package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import static softeer2nd.chess.Direction.*;
import static softeer2nd.chess.board.Board.BOARD_SIZE;
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
                return verifyWhiteMovePosition(sourcePosition, dx, dy);
            case BLACK:
                return verifyBlackMovePosition(sourcePosition, dx, dy);
            default:
                throw new IllegalArgumentException(PIECE_INVALID_COLOR.getMessage());
        }
    }

    private boolean verifyWhiteMovePosition(Position sourcePosition, int dx, int dy) {
        boolean match =  whitePawnDirection().stream()
                .anyMatch(direction -> direction.getXDegree() == dx && direction.getYDegree() == dy);
        if (match) return true;
        if (sourcePosition.getY() + 2 == BOARD_SIZE) return NN.getXDegree() == dx && NN.getYDegree() == dy;
        return false;
    }

    private boolean verifyBlackMovePosition(Position sourcePosition, int dx, int dy) {
        boolean match =  blackPawnDirection().stream()
                .anyMatch(direction -> direction.getXDegree() == dx && direction.getYDegree() == dy);
        if (match) return true;
        if (sourcePosition.getY() + 7 == BOARD_SIZE) return SS.getXDegree() == dx && SS.getYDegree() == dy;
        return false;
    }
}
