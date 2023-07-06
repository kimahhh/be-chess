package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Piece.*;

class PieceTest {

    @Test
    @DisplayName("색과 종류를 입력받아 기물을 생성할 수 있어야 한다")
    public void create() {
        verifyCreatePiece(createPiece(Color.WHITE, Type.KING), Color.WHITE, Type.KING);
        verifyCreatePiece(createPiece(Color.BLACK, Type.KING), Color.BLACK, Type.KING);
        verifyCreatePiece(createPiece(Color.WHITE, Type.QUEEN), Color.WHITE, Type.QUEEN);
        verifyCreatePiece(createPiece(Color.BLACK, Type.QUEEN), Color.BLACK, Type.QUEEN);
        verifyCreatePiece(createPiece(Color.WHITE, Type.ROOK), Color.WHITE, Type.ROOK);
        verifyCreatePiece(createPiece(Color.BLACK, Type.ROOK), Color.BLACK, Type.ROOK);
        verifyCreatePiece(createPiece(Color.WHITE, Type.BISHOP), Color.WHITE, Type.BISHOP);
        verifyCreatePiece(createPiece(Color.BLACK, Type.BISHOP), Color.BLACK, Type.BISHOP);
        verifyCreatePiece(createPiece(Color.WHITE, Type.KNIGHT), Color.WHITE, Type.KNIGHT);
        verifyCreatePiece(createPiece(Color.BLACK, Type.KNIGHT), Color.BLACK, Type.KNIGHT);
        verifyCreatePiece(createPiece(Color.WHITE, Type.PAWN), Color.WHITE, Type.PAWN);
        verifyCreatePiece(createPiece(Color.BLACK, Type.PAWN), Color.BLACK, Type.PAWN);
        verifyCreatePiece(createBlank(), Color.NO_COLOR, Type.NO_PIECE);
    }

    private void verifyCreatePiece(final Piece piece, final Color color, final Type type) {
        assertEquals(color, piece.getColor());
        assertEquals(type, piece.getType());
        assertEquals(type.getWhiteRepresentation(), piece.getType().getWhiteRepresentation());
        assertEquals(type.getBlackRepresentation(), piece.getType().getBlackRepresentation());
    }

    @Test
    @DisplayName("색과 종류를 입력받아 생성된 기물의 색깔을 확인할 수 있어야 한다")
    public void color() {
        verifyWhitePiece(createPiece(Color.WHITE, Type.KING));
        verifyWhitePiece(createPiece(Color.WHITE, Type.QUEEN));
        verifyWhitePiece(createPiece(Color.WHITE, Type.ROOK));
        verifyWhitePiece(createPiece(Color.WHITE, Type.BISHOP));
        verifyWhitePiece(createPiece(Color.WHITE, Type.KNIGHT));
        verifyWhitePiece(createPiece(Color.WHITE, Type.PAWN));
        verifyBlackPiece(createPiece(Color.BLACK, Type.KING));
        verifyBlackPiece(createPiece(Color.BLACK, Type.QUEEN));
        verifyBlackPiece(createPiece(Color.BLACK, Type.ROOK));
        verifyBlackPiece(createPiece(Color.BLACK, Type.BISHOP));
        verifyBlackPiece(createPiece(Color.BLACK, Type.KNIGHT));
        verifyBlackPiece(createPiece(Color.BLACK, Type.PAWN));
    }

    private void verifyWhitePiece(final Piece piece) {
        assertTrue(piece.isWhite());
        assertFalse(piece.isBlack());
    }
    private void verifyBlackPiece(final Piece piece) {
        assertTrue(piece.isBlack());
        assertFalse(piece.isWhite());
    }

}