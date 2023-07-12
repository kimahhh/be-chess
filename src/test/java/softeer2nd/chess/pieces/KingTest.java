package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.King.createBlackKing;
import static softeer2nd.chess.pieces.King.createWhiteKing;

class KingTest {

    @Test
    @DisplayName("King 기물을 생성할 수 있어야 한다")
    void create() {
        verifyCreatePiece(createWhiteKing(), Piece.Color.WHITE, Piece.Type.KING, 'k');
        verifyCreatePiece(createBlackKing(), Piece.Color.BLACK, Piece.Type.KING, 'K');
    }

    private void verifyCreatePiece(final Piece piece, final Piece.Color color, final Piece.Type type, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(type, piece.getType());
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("King 기물의 움직임 가능 여부를 판별할 수 있어야 한다")
    void verifyMove() {
        Position sourcePosition = new Position("d5");
        Position targetPosition = new Position("e6");
        Piece piece = createWhiteKing();
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition));

        targetPosition = new Position("e7");
        assertFalse(piece.verifyMovePosition(sourcePosition, targetPosition));
    }

}