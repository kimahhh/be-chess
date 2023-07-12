package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Rook.createBlackRook;
import static softeer2nd.chess.pieces.Rook.createWhiteRook;

class RookTest {

    @Test
    @DisplayName("Rook 기물을 생성할 수 있어야 한다")
    void create() {
        verifyCreatePiece(createWhiteRook(), Piece.Color.WHITE, Piece.Type.ROOK, 'r');
        verifyCreatePiece(createBlackRook(), Piece.Color.BLACK, Piece.Type.ROOK, 'R');
    }

    private void verifyCreatePiece(final Piece piece, final Piece.Color color, final Piece.Type type, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(type, piece.getType());
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("Rook 기물의 움직임 가능 여부를 판별할 수 있어야 한다")
    void verifyMove() {
        Position sourcePosition = new Position("b6");
        Position targetPosition = new Position("b2");
        Piece piece = createWhiteRook();
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition));

        targetPosition = new Position("h6");
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition));

        targetPosition = new Position("c8");
        assertFalse(piece.verifyMovePosition(sourcePosition, targetPosition));
    }
}