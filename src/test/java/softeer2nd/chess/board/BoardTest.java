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

    @BeforeEach
    void setup() {
        // Given
        board = new Board();
        chessGame = new ChessGame();

        // When
        chessGame.initializeBasic(board);
    }

    @Test
    @DisplayName("모든 기물의 개수를 반환할 수 있어야 한다")
    void getPieceCount() {
        // Then
        assertEquals(32, board.pieceCount());

        // Given
        String sample = ".KR....." +
                "P.PB...." +
                ".P..Q..." +
                "........" +
                ".....nq." +
                ".....p.." +
                "......p." +
                "....rk..";

        // When
        chessGame.initialize(board, sample);

        // Then
        assertEquals(13, board.pieceCount());
    }

    @Test
    @DisplayName("기물의 색과 종류를 인자로 받아 해당 기물의 개수를 반환할 수 있어야 한다")
    void getPieceCountWithColorAndType() {
        // Then
        assertEquals(8, board.pieceCount(Color.WHITE, Type.PAWN));
        assertEquals(2, board.pieceCount(Color.BLACK, Type.ROOK));
        assertEquals(1, board.pieceCount(Color.BLACK, Type.QUEEN));
    }

    @Test
    @DisplayName("좌표를 인자로 받아 해당 좌표의 기물을 조회할 수 있어야 한다")
    void getPieceWithCoordinate() {
        // Then
        assertEquals(createPiece(Color.BLACK, Type.ROOK), board.findPiece(new Position("a8")));
        assertEquals(createPiece(Color.WHITE, Type.KING), board.findPiece(new Position("e1")));
    }

    @Test
    @DisplayName("기물의 점수가 낮은 순으로 정렬할 수 있어야 한다")
    void sortAscPieces() {
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
        ArrayList<Piece> sortAscBlackPieces = board.sortAscPieces(Color.BLACK);
        ArrayList<Piece> sortAscWhitePieces = board.sortAscPieces(Color.WHITE);

        // Then
        assertEquals(King.createBlackKing(), sortAscBlackPieces.get(0));
        assertEquals(Queen.createBlackQueen(), sortAscBlackPieces.get(sortAscBlackPieces.size() - 1));
        assertEquals(Pawn.createWhitePawn(), sortAscWhitePieces.get(1));
        assertEquals(Rook.createWhiteRook(), sortAscWhitePieces.get(sortAscWhitePieces.size() - 2));
    }

    @Test
    @DisplayName("기물의 점수가 높은 순으로 정렬할 수 있어야 한다")
    void sortDescPieces() {
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
        ArrayList<Piece> sortDescBlackPieces = board.sortDescPieces(Color.BLACK);
        ArrayList<Piece> sortDescWhitePieces = board.sortDescPieces(Color.WHITE);

        // Then
        assertEquals(Queen.createBlackQueen(), sortDescBlackPieces.get(0));
        assertEquals(King.createBlackKing(), sortDescBlackPieces.get(sortDescBlackPieces.size() - 1));
        assertEquals(Rook.createWhiteRook(), sortDescWhitePieces.get(1));
        assertEquals(Pawn.createWhitePawn(), sortDescWhitePieces.get(sortDescWhitePieces.size() - 2));
    }
}