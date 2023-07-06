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

    @Test
    @DisplayName("같은 세로줄에 같은 색의 폰이 없는 경우의 점수를 계산할 수 있다")
    public void calculatePointNoSameLinePawn() {
        String boardString = ".KR....." +
                "P.PB...." +
                ".P..Q..." +
                "........" +
                ".....nq." +
                ".....p.p" +
                "......p." +
                "....rk..";
        board.initialize(boardString);
        assertEquals(20, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(19.5, board.calculatePoint(Color.WHITE), 0.01);
    }

    @Test
    @DisplayName("같은 세로줄에 같은 색의 폰이 있는 경우의 점수를 계산할 수 있다")
    public void calculatePointYesSameLinePawn() {
        String boardString = ".KR....." +
                "P.PB...." +
                ".P..Q..." +
                "........" +
                ".....nq." +
                ".....p.p" +
                ".....pp." +
                "....rk..";
        board.initialize(boardString);
        assertEquals(20, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(19.5, board.calculatePoint(Color.WHITE), 0.01);
    }

    @Test
    @DisplayName("특정 상태의 체스판의 점수를 계산할 수 있다")
    public void calculatePoint() {
        board.initializeEmpty();

        board.move("b6", createPiece(Color.BLACK, Type.PAWN));
        board.move("e6", createPiece(Color.BLACK, Type.QUEEN));
        board.move("b8", createPiece(Color.BLACK, Type.KING));
        board.move("c8", createPiece(Color.BLACK, Type.ROOK));

        board.move("f2", createPiece(Color.WHITE, Type.PAWN));
        board.move("g2", createPiece(Color.WHITE, Type.PAWN));
        board.move("e1", createPiece(Color.WHITE, Type.ROOK));
        board.move("f1", createPiece(Color.WHITE, Type.KING));

        assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(7.0, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }
}