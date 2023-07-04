package softeer2nd.chess;

import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void create() {
        Board board = new Board();

        verifyBoard(board, Pawn.WHITE_COLOR, 1, 0);
        verifyBoard(board, Pawn.BLACK_COLOR, 2, 1);
    }

    private void verifyBoard(Board board, String color, int size, int index) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(size, board.size());
        assertEquals(pawn, board.findPawn(index));
    }

}