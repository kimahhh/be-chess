package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    public void create() {
        verifyBoard(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION, 1, 0);
        verifyBoard(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION, 2, 1);
    }

    private void verifyBoard(String color, String representation, int size, int index) {
        Piece pawn = new Piece(color, representation);
        board.add(pawn);
        assertEquals(size, board.size());
        assertEquals(pawn, board.findPawn(index));
    }

    @Test
    public void boardPrint() {
        initialize();
        String strBoard = "........\nPPPPPPPP\n........\n........\n" +
                          "........\n........\npppppppp\n........\n";
        assertEquals(strBoard, board.print());
    }

    private void initialize() {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

}