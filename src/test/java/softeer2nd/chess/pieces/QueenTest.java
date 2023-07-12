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
        Position sourcePosition = new Position("a1");
        Position targetPosition = new Position("g7");
        Piece piece = createWhiteQueen();
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition));

        targetPosition = new Position("a5");
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition));

        targetPosition = new Position("f7");
        assertFalse(piece.verifyMovePosition(sourcePosition, targetPosition));
    }

}