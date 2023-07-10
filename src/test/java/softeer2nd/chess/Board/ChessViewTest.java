package softeer2nd.chess.Board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ChessViewTest {

    private Board board;
    private ChessView chessView;
    private ChessGame chessGame;
    private String sample1 = ".KR....." +
            "P.PB...." +
            ".P..Q..." +
            "........" +
            ".....nq." +
            ".....p.." +
            "......p." +
            "....rk..";
    private String sample2 = "........" +
            "........" +
            "........" +
            "........" +
            "........" +
            "........" +
            "........" +
            "........";

    @BeforeEach
    public void setup() {
        board = new Board();
        chessView = new ChessView();
        chessGame = new ChessGame();
    }

    @Test
    @DisplayName("Board를 출력할 수 있어야 한다")
    public void printBoard() {
        String basic = "RNBQKBNR\n" +
                "PPPPPPPP\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "pppppppp\n" +
                "rnbqkbnr\n";
        chessGame.initializeBasic(board);
        assertEquals(basic, chessView.showBoard(board));
    }

    @Test
    @DisplayName("Board의 상태를 좌표와 함께 출력할 수 있어야 한다")
    public void showBoardWithXYTest() {
        String boardString = ".KR.....  8\n" +
                "P.PB....  7\n" +
                ".P..Q...  6\n" +
                "........  5\n" +
                ".....nq.  4\n" +
                ".....p..  3\n" +
                "......p.  2\n" +
                "....rk..  1\n" +
                "abcdefgh\n";
        chessGame.initialize(board, sample1);
        assertEquals(boardString, chessView.showBoardWithXY(board));

        String noPiece = "........  8\n" +
                "........  7\n" +
                "........  6\n" +
                "........  5\n" +
                "........  4\n" +
                "........  3\n" +
                "........  2\n" +
                "........  1\n" +
                "abcdefgh\n";
        chessGame.initialize(board, sample2);
        assertEquals(noPiece, chessView.showBoardWithXY(board));
    }
}