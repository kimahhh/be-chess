package softeer2nd.chess.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import softeer2nd.chess.Position;
import softeer2nd.chess.pieces.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Piece.*;

class BoardTest {

    private Board board;
    private ChessGame chessGame;
    private String sample1 = ".KR....." +
                            "P.PB...." +
                            ".P..Q..." +
                            "........" +
                            ".....nq." +
                            ".....p.." +
                            "......p." +
                            "....rk..";
    private String noSameLinePawn = ".KR....." +
            "P.PB...." +
            ".P..Q..." +
            "........" +
            ".....nq." +
            ".....p.p" +
            "......p." +
            "....rk..";
    private String yesSameLinePawn = ".KR....." +
            "P.PB...." +
            ".P..Q..." +
            "........" +
            ".....nq." +
            ".....p.p" +
            ".....pp." +
            "....rk..";

    @BeforeEach
    public void setup() {
        board = new Board();
        chessGame = new ChessGame();
    }

    @Test
    @DisplayName("모든 기물의 개수를 반환할 수 있어야 한다")
    public void getPieceCount() {
        chessGame.initializeBasic(board);
        assertEquals(32, board.pieceCount());

        chessGame.initialize(board, sample1);
        assertEquals(13, board.pieceCount());
    }

    @Test
    @DisplayName("기물의 색과 종류를 인자로 받아 해당 기물의 개수를 반환할 수 있어야 한다")
    public void getPieceCountWithColorAndType() {
        chessGame.initializeBasic(board);
        assertEquals(8, board.pieceCount(Color.WHITE, Type.PAWN));
        assertEquals(2, board.pieceCount(Color.BLACK, Type.ROOK));
        assertEquals(1, board.pieceCount(Color.BLACK, Type.QUEEN));
    }

    @Test
    @DisplayName("좌표를 인자로 받아 해당 좌표의 기물을 조회할 수 있어야 한다")
    public void getPieceWithCoordinate() {
        chessGame.initializeBasic(board);
        assertEquals(board.getBoard().get(0).rank.get(0), board.findPiece(new Position("a8")));
        assertEquals(board.getBoard().get(7).rank.get(4), board.findPiece(new Position("e1")));
    }

    @Test
    @DisplayName("기물의 점수가 낮은 순으로 정렬할 수 있어야 한다")
    public void sortAscPieces() {
        chessGame.initialize(board, noSameLinePawn);

        ArrayList<Piece> sortAscBlackPieces = board.sortAscPieces(Color.BLACK);
        ArrayList<Piece> sortAscWhitePieces = board.sortAscPieces(Color.WHITE);

        assertEquals(King.createBlackKing(), sortAscBlackPieces.get(0));
        assertEquals(Queen.createBlackQueen(), sortAscBlackPieces.get(sortAscBlackPieces.size() - 1));
        assertEquals(Pawn.createWhitePawn(), sortAscWhitePieces.get(1));
        assertEquals(Rook.createWhiteRook(), sortAscWhitePieces.get(sortAscWhitePieces.size() - 2));
    }

    @Test
    @DisplayName("기물의 점수가 높은 순으로 정렬할 수 있어야 한다")
    public void sortDescPieces() {
        chessGame.initialize(board, yesSameLinePawn);

        ArrayList<Piece> sortDescBlackPieces = board.sortDescPieces(Color.BLACK);
        ArrayList<Piece> sortDescWhitePieces = board.sortDescPieces(Color.WHITE);

        assertEquals(Queen.createBlackQueen(), sortDescBlackPieces.get(0));
        assertEquals(King.createBlackKing(), sortDescBlackPieces.get(sortDescBlackPieces.size() - 1));
        assertEquals(Rook.createWhiteRook(), sortDescWhitePieces.get(1));
        assertEquals(Pawn.createWhitePawn(), sortDescWhitePieces.get(sortDescWhitePieces.size() - 2));
    }
}