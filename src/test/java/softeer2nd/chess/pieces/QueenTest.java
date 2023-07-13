package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Queen.createBlackQueen;
import static softeer2nd.chess.pieces.Queen.createWhiteQueen;

class QueenTest {

    @Test
    @DisplayName("Queen 기물을 생성할 수 있어야 한다")
    void create() {
        verifyCreatePiece(createWhiteQueen(), Piece.Color.WHITE, Piece.Type.QUEEN, 'q');
        verifyCreatePiece(createBlackQueen(), Piece.Color.BLACK, Piece.Type.QUEEN, 'Q');
    }

    private void verifyCreatePiece(final Piece piece, final Piece.Color color, final Piece.Type type, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(type, piece.getType());
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("Queen 기물의 움직임 가능 여부를 판별할 수 있어야 한다")
    void verifyMove() {
        // Given
        Position sourcePosition = new Position("a1");
        Position targetPosition1 = new Position("g7");
        Position targetPosition2 = new Position("a5");
        Position targetPosition3 = new Position("f7");

        // When
        Piece piece = createWhiteQueen();

        // Then
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition1));
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition2));
        assertFalse(piece.verifyMovePosition(sourcePosition, targetPosition3));
    }

}