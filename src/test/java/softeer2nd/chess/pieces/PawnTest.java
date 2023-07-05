package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @Test
    @DisplayName("폰 생성")
    public void create() {
        verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }

    @Test
    @DisplayName("매개변수가 없다면 흰색 폰 생성")
    public void createBasicConstructor() {
        Piece pawn = new Piece();
        assertEquals(Piece.WHITE_COLOR, pawn.getColor());
        assertEquals(Piece.WHITE_REPRESENTATION, pawn.getRepresentation());
    }

    private void verifyPawn(final String color, final String representation) {
        Piece pawn = new Piece(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }

}