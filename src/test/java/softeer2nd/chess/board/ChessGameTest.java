package softeer2nd.chess.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.chess.pieces.Pawn;
import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.board.ChessGame.move;
import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.exception.Exception.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class ChessGameTest {
    private Board board;
    private ChessView chessView;
    private ChessGame chessGame;

    @BeforeEach
    public void setup() {
        // Given
        board = new Board();
        chessView = new ChessView();
        chessGame = new ChessGame();
    }


    @Test
    @DisplayName("Board를 초기화할 수 있어야 한다")
    public void initialize() {
        // When
        chessGame.initializeBasic(board);

        // Then
        String blackRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blackRank + blackRank + blackRank + blackRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                chessView.showBoard(board)
        );

        // When

        // Then
        chessGame.initializeEmpty(board);
        assertEquals(blackRank + blackRank + blackRank + blackRank +
                        blackRank + blackRank + blackRank + blackRank,
                chessView.showBoard(board));
    }

    @Test
    @DisplayName("Board를 입력받는 String을 사용해 초기화할 수 있어야 한다")
    public void initializeState() {
        // Given
        String boardString = ".KR.....\n" +
                "P.PB....\n" +
                ".P..Q...\n" +
                "........\n" +
                ".....nq.\n" +
                ".....p..\n" +
                "......p.\n" +
                "....rk..\n";
        String sample1 = ".KR....." +
                "P.PB...." +
                ".P..Q..." +
                "........" +
                ".....nq." +
                ".....p.." +
                "......p." +
                "....rk..";

        // When
        chessGame.initialize(board, sample1);

        // Then
        assertEquals(boardString, chessView.showBoard(board));

        // Given
        String noPiece = "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n";
        String sample2 = "........" +
                "........" +
                "........" +
                "........" +
                "........" +
                "........" +
                "........" +
                "........";

        // When
        chessGame.initialize(board, sample2);

        // Then
        assertEquals(noPiece, chessView.showBoard(board));
    }

    @Test
    @DisplayName("좌표와 기물을 인자로 받아 해당 좌표로 해당 기물을 이동할 수 있어야 한다")
    public void moveTest() {
        // When
        chessGame.initializeEmpty(board);

        Position position = new Position("b5");
        Piece piece = createPiece(Piece.Color.BLACK, Piece.Type.ROOK);
        move(board, position, piece);

        // Then
        assertEquals(piece, board.findPiece(position));
    }

    @Test
    @DisplayName("현재 좌표와 타겟 좌표를 인자로 받아 현재 좌표에 있는 기물을 타겟 좌표로 이동할 수 있어야 한다")
    public void moveWithCoordinate() {
        // When
        chessGame.initializeBasic(board);

        Position sourcePosition = new Position("b2");
        Position targetPosition = new Position("b3");
        move(board, sourcePosition, targetPosition);

        // Then
        assertEquals(createBlank(), board.findPiece(sourcePosition));
        assertEquals(Pawn.createWhitePawn(), board.findPiece(targetPosition));
    }

    @Test
    @DisplayName("같은 위치로는 이동할 수 없어야 한다")
    void cantMoveToSamePosition() {
        // When
        chessGame.initializeBasic(board);
        Position sourcePosition = new Position("b2");
        Position targetPosition = new Position("b2");
        Exception exception = assertThrows(Exception.class, () -> {
            move(board, sourcePosition, targetPosition);
        });

        // Then
        assertEquals(POSITION_MOVE_TO_SAME_POSITION.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("이동할 차례를 지켜야 한다")
    void waitYourTurn() {
        // When
        chessGame.initializeBasic(board);

        Exception exception = assertThrows(Exception.class, () -> {
            move(board, new Position("b7"), new Position("b5"));
        });

        // Then
        assertEquals("흰" + NOT_YOUR_TURN.getMessage(), exception.getMessage());

        // When
        move(board, new Position("d2"), new Position("d4"));
        exception = assertThrows(Exception.class, () -> {
            move(board,new Position("d1"), new Position("d2"));
        });

        // Then
        assertEquals("검은" + NOT_YOUR_TURN.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("이동할 수 없는 위치로는 이동할 수 없어야 한다")
    void cantMoveToWrongPosition() {
        // When
        chessGame.initializeBasic(board);
        Position sourcePosition = new Position("b2");
        Position targetPosition = new Position("b5");
        Exception exception = assertThrows(Exception.class, () -> {
            move(board, sourcePosition, targetPosition);
        });

        // Then
        assertEquals(PIECE_INVALID_POSITION.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("같은 색의 기물을 잡을 수 없어야 한다")
    void cantCatchSameColor() {
        // When
        chessGame.initializeBasic(board);
        Position sourcePosition = new Position("d1");
        Position targetPosition = new Position("e2");
        Exception exceptioin = assertThrows(Exception.class, () -> {
           move(board, sourcePosition, targetPosition);
        });

        // Then
        assertEquals(PIECE_CANT_CATCH_SAME_COLOR.getMessage(), exceptioin.getMessage());

    }

    @Test
    @DisplayName("같은 세로줄에 같은 색의 폰이 없는 경우의 점수를 계산할 수 있다")
    public void calculatePointNoSameLinePawn() {
        // Given
        String noSameLinePawn = ".KR....." +
                "P.PB...." +
                ".P..Q..." +
                "........" +
                ".....nq." +
                ".....p.p" +
                "......p." +
                "....rk..";

        // When
        chessGame.initialize(board, noSameLinePawn);

        // Then
        assertEquals(20, chessGame.calculatePoint(board, Piece.Color.BLACK), 0.01);
        assertEquals(19.5, chessGame.calculatePoint(board, Color.WHITE), 0.01);
    }

    @Test
    @DisplayName("같은 세로줄에 같은 색의 폰이 있는 경우의 점수를 계산할 수 있다")
    public void calculatePointYesSameLinePawn() {
        // Given
        String yesSameLinePawn = ".KR....." +
                "P.PB...." +
                ".P..Q..." +
                "........" +
                ".....nq." +
                ".....p.p" +
                ".....pp." +
                "....rk..";

        // When
        chessGame.initialize(board, yesSameLinePawn);

        // Then
        assertEquals(20, chessGame.calculatePoint(board, Color.BLACK), 0.01);
        assertEquals(19.5, chessGame.calculatePoint(board, Color.WHITE), 0.01);
    }

    @Test
    @DisplayName("특정 상태의 체스판의 점수를 계산할 수 있다")
    public void calculatePoint() {
        // When
        chessGame.initializeEmpty(board);

        move(board, new Position("b6"), createPiece(Color.BLACK, Type.PAWN));
        move(board, new Position("e6"), createPiece(Color.BLACK, Type.QUEEN));
        move(board, new Position("b8"), createPiece(Color.BLACK, Type.KING));
        move(board, new Position("c8"), createPiece(Color.BLACK, Type.ROOK));

        move(board, new Position("f2"), createPiece(Color.WHITE, Type.PAWN));
        move(board, new Position("g2"), createPiece(Color.WHITE, Type.PAWN));
        move(board, new Position("e1"), createPiece(Color.WHITE, Type.ROOK));
        move(board, new Position("f1"), createPiece(Color.WHITE, Type.KING));

        // Then
        assertEquals(15.0, chessGame.calculatePoint(board, Color.BLACK), 0.01);
        assertEquals(7.0, chessGame.calculatePoint(board, Color.WHITE), 0.01);
    }

}