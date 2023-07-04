package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    public void create() {
        verifyBoard(Pawn.WHITE_COLOR, 1, 0);
        verifyBoard(Pawn.BLACK_COLOR, 2, 1);
    }

    private void verifyBoard(String color, int size, int index) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(size, board.size());
        assertEquals(pawn, board.findPawn(index));
    }

}