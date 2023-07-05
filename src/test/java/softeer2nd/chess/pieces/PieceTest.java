package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Piece.*;

class PieceTest {

    @Test
    @DisplayName("기물 생성")
    public void create() {
        verifyPiece(Piece.createWhiteKing(), WHITE_COLOR, WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(), BLACK_COLOR, BLACK_KING_REPRESENTATION);
        verifyPiece(Piece.createWhiteQueen(), WHITE_COLOR, WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(), BLACK_COLOR, BLACK_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createWhiteRook(), WHITE_COLOR, WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(), BLACK_COLOR, BLACK_ROOK_REPRESENTATION);
        verifyPiece(Piece.createWhiteBishop(), WHITE_COLOR, WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(), BLACK_COLOR, BLACK_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createWhiteKnight(), WHITE_COLOR, WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(), BLACK_COLOR, BLACK_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createWhitePawn(), WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("기물 색깔 검증")
    public void color() {
        verifyWhitePiece(createWhiteKing());
        verifyWhitePiece(createWhiteQueen());
        verifyWhitePiece(createWhiteRook());
        verifyWhitePiece(createWhiteBishop());
        verifyWhitePiece(createWhiteKnight());
        verifyWhitePiece(createWhitePawn());
        verifyBlackPiece(createBlackKing());
        verifyBlackPiece(createBlackQueen());
        verifyBlackPiece(createBlackRook());
        verifyBlackPiece(createBlackBishop());
        verifyBlackPiece(createBlackKnight());
        verifyBlackPiece(createBlackPawn());
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