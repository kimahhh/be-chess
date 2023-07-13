package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Knight.createBlackKnight;
import static softeer2nd.chess.pieces.Knight.createWhiteKnight;
import static softeer2nd.chess.pieces.Queen.createBlackQueen;
import static softeer2nd.chess.pieces.Queen.createWhiteQueen;

class KnightTest {

    @Test
    @DisplayName("Knight 기물을 생성할 수 있어야 한다")
    void create() {
        verifyCreatePiece(createWhiteKnight(), Piece.Color.WHITE, Piece.Type.KNIGHT, 'n');
        verifyCreatePiece(createBlackKnight(), Piece.Color.BLACK, Piece.Type.KNIGHT, 'N');
    }

    private void verifyCreatePiece(final Piece piece, final Piece.Color color, final Piece.Type type, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(type, piece.getType());
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("Knight 기물의 움직임 가능 여부를 판별할 수 있어야 한다")
    void verifyMove() {
        // Given
        Position sourcePosition = new Position("d5");
        Position targetPosition1 = new Position("e7");
        Position targetPosition2 = new Position("f3");

        // When
        Piece piece = createWhiteKnight();

        // Then
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition1));
        assertFalse(piece.verifyMovePosition(sourcePosition, targetPosition2));
    }
}