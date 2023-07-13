package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Pawn.createBlackPawn;
import static softeer2nd.chess.pieces.Pawn.createWhitePawn;

class PawnTest {

    @Test
    @DisplayName("Pawn 기물을 생성할 수 있어야 한다")
    void create() {
        verifyCreatePiece(createWhitePawn(), Piece.Color.WHITE, Piece.Type.PAWN, 'p');
        verifyCreatePiece(createBlackPawn(), Piece.Color.BLACK, Piece.Type.PAWN, 'P');
    }

    private void verifyCreatePiece(final Piece piece, final Piece.Color color, final Piece.Type type, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(type, piece.getType());
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("White Pawn 기물의 움직임 가능 여부를 판별할 수 있어야 한다")
    void verifyMoveWhite() {
        Position sourcePosition = new Position("a2");
        Position targetPosition = new Position("a3");
        Piece piece = createWhitePawn();
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition));

        targetPosition = new Position("b2");
        assertFalse(piece.verifyMovePosition(sourcePosition, targetPosition));
    }

    @Test
    @DisplayName("White Pawn 기물의 첫 이동 예외처리(두 칸 전진 가능)를 할 수 있어야 한다")
    void verifyMoveWhiteFirst() {
        Position sourcePosition = new Position("d2");
        Position targetPosition = new Position("d4");
        Piece piece = createWhitePawn();
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition));
    }

    @Test
    @DisplayName("Black Pawn 기물의 움직임 가능 여부를 판별할 수 있어야 한다")
    void verifyMoveBlack() {
        Position sourcePosition = new Position("h5");
        Position targetPosition = new Position("g4");
        Piece piece = createBlackPawn();
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition));

        targetPosition = new Position("h3");
        assertFalse(piece.verifyMovePosition(sourcePosition, targetPosition));
    }

    @Test
    @DisplayName("Black Pawn 기물의 첫 이동 예외처리(두 칸 전진 가능)를 할 수 있어야 한다")
    void verifyMoveBlackFirst() {
        Position sourcePosition = new Position("e7");
        Position targetPosition = new Position("e5");
        Piece piece = createBlackPawn();
        assertTrue(piece.verifyMovePosition(sourcePosition, targetPosition));
    }
}