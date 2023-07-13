package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Bishop.createBlackBishop;
import static softeer2nd.chess.pieces.Bishop.createWhiteBishop;

class BishopTest {

    @Test
    @DisplayName("Bishop 기물을 생성할 수 있어야 한다")
    void create() {
        verifyCreatePiece(createWhiteBishop(), Piece.Color.WHITE, Piece.Type.BISHOP, 'b');
        verifyCreatePiece(createBlackBishop(), Piece.Color.BLACK, Piece.Type.BISHOP, 'B');
    }

    private void verifyCreatePiece(final Piece piece, final Piece.Color color, final Piece.Type type, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(type, piece.getType());
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("Bishop 기물의 움직임 가능 여부를 판별할 수 있어야 한다")
    void verifyMove() {
        // Given
        Position sourcePosition = new Position("c8");
        Position targetPosition1 = new Position("h3");
        Position targetPosition2 = new Position("f5");
        Position targetPosition3 = new Position("e5");

        // When
        Piece piece = createWhiteBishop();

        // Then
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition1));
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition2));
        assertFalse(piece.verifyMovePosition(sourcePosition, targetPosition3));
    }
}