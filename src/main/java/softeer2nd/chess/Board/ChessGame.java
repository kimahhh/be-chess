package softeer2nd.chess.Board;


import softeer2nd.chess.pieces.Piece;

import static softeer2nd.chess.Board.Board.BOARD_SIZE;
import static softeer2nd.chess.Position.getX;
import static softeer2nd.chess.Position.getY;
import static softeer2nd.chess.pieces.Piece.*;

public class ChessGame {

    public void initialize(Board board, String boardString) {
        board.getBoard().clear();
        for(int y = 0;y < BOARD_SIZE;y++) {
            Rank rank = new Rank();
            for (int x = 0;x < BOARD_SIZE;x++) {
                rank.rank.add(createPiece(boardString.charAt(y * BOARD_SIZE + x)));
            }
            board.getBoard().add(rank);
        }
    }

    public void initializeBasic(Board board) {
        String basic = "RNBQKBNR" +
                "PPPPPPPP" +
                "........" +
                "........" +
                "........" +
                "........" +
                "pppppppp" +
                "rnbqkbnr";
        initialize(board, basic);
    }

    public void initializeEmpty(Board board) {
        String noPiece = "........" +
                "........" +
                "........" +
                "........" +
                "........" +
                "........" +
                "........" +
                "........";
        initialize(board, noPiece);
    }

    public static void move(Board board, String position, Piece piece) {
        board.getBoard().get(BOARD_SIZE - getY(position.charAt(1)))
                .rank.set(getX(position.charAt(0)), piece);
    }

    public static void move(Board board, String sourcePosition, String targetPosition) {
        Piece piece = board.findPiece(sourcePosition);
        Piece diePiece = board.findPiece(targetPosition);
        if (diePiece.getType().equals(Piece.Type.NO_PIECE)) {
            move(board, sourcePosition, diePiece);
        }
        else {
            move(board, sourcePosition, createBlank());
        }
        move(board, targetPosition, piece);
    }

    public double calculatePoint(Board board, Color color) {
        return board.getBoard().stream()
                .flatMap(rank -> rank.rank.stream())
                .filter(piece -> piece.getColor().equals(color))
                .mapToDouble(Piece::getPoint)
                .sum() - countSameLinePawn(board, color) * 0.5;
    }

    private int countSameLinePawn(Board board, Color color) {
        int num = 0;
        for (int x = 0;x < BOARD_SIZE;x++) {
            int cnt = 0;
            for (Rank rank : board.getBoard()) {
                Piece piece = rank.rank.get(x);
                if (piece.getType().equals(Piece.Type.PAWN) && piece.getColor().equals(color)) {
                    cnt++;
                }
            }
            if (cnt >= 2) {
                num += cnt;
            }
        }
        return num;
    }
}
