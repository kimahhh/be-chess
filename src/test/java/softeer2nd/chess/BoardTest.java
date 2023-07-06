package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.utils.StringUtils.appendNewLine;
import static softeer2nd.chess.pieces.Piece.*;

class BoardTest {

    private Board board;
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
    }

    @Test
    @DisplayName("Board를 초기화할 수 있어야 한다")
    public void initialize() {
        board.initializeBasic();
        String blackRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blackRank + blackRank + blackRank + blackRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard()
        );

        board.initializeEmpty();
        assertEquals(blackRank + blackRank + blackRank + blackRank +
                blackRank + blackRank + blackRank + blackRank,
                board.showBoard());
    }

    @Test
    @DisplayName("Board를 입력받는 String을 사용해 초기화할 수 있어야 한다")
    public void initializeState() {
        String boardString = ".KR.....\n" +
                "P.PB....\n" +
                ".P..Q...\n" +
                "........\n" +
                ".....nq.\n" +
                ".....p..\n" +
                "......p.\n" +
                "....rk..\n";
        board.initialize(sample1);
        assertEquals(boardString, board.showBoard());

        String noPiece = "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n";
        board.initialize(sample2);
        assertEquals(noPiece, board.showBoard());
    }

    @Test
    @DisplayName("모든 기물의 개수를 반환할 수 있어야 한다")
    public void getPieceCount() {
        board.initializeBasic();
        assertEquals(32, board.pieceCount());

        board.initialize(sample1);
        assertEquals(13, board.pieceCount());
    }

    @Test
    @DisplayName("기물의 색과 종류를 인자로 받아 해당 기물의 개수를 반환할 수 있어야 한다")
    public void getPieceCountWithColorAndType() {
        board.initializeBasic();
        assertEquals(8, board.pieceCount(Color.WHITE, Type.PAWN));
        assertEquals(2, board.pieceCount(Color.BLACK, Type.ROOK));
        assertEquals(1, board.pieceCount(Color.BLACK, Type.QUEEN));
    }

    @Test
    @DisplayName("좌표를 인자로 받아 해당 좌표의 기물을 조회할 수 있어야 한다")
    public void getPieceWithCoordinate() {
        board.initializeBasic();
        assertEquals(board.getBoard().get(0).rank.get(0), board.findPiece("a8"));
        assertEquals(board.getBoard().get(7).rank.get(4), board.findPiece("e1"));
    }

    @Test
    @DisplayName("좌표와 기물을 인자로 받아 해당 좌표로 해당 기물을 이동할 수 있어야 한다")
    public void move() {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = createPiece(Color.BLACK, Type.ROOK);
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }
}