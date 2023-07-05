package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("기물 생성")
    public void create() {
        verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);
        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION);
        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("기물 색깔 검증")
    public void color() {
        verifyWhitePiece(Piece.createWhiteKing());
        verifyWhitePiece(Piece.createWhiteQueen());
        verifyWhitePiece(Piece.createWhiteRook());
        verifyWhitePiece(Piece.createWhiteBishop());
        verifyWhitePiece(Piece.createWhiteKnight());
        verifyWhitePiece(Piece.createWhitePawn());
        verifyBlackPiece(Piece.createBlackKing());
        verifyBlackPiece(Piece.createBlackQueen());
        verifyBlackPiece(Piece.createBlackRook());
        verifyBlackPiece(Piece.createBlackBishop());
        verifyBlackPiece(Piece.createBlackKnight());
        verifyBlackPiece(Piece.createBlackPawn());
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