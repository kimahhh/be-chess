package softeer2nd.chess.Board;


import softeer2nd.chess.Position;
import softeer2nd.chess.pieces.Piece;

import static softeer2nd.chess.Board.Board.BOARD_SIZE;
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

    public static void move(Board board, Position position, Piece piece) {
        board.getBoard().get(position.getY())
                .rank.set(position.getX(), piece);
    }

    public static void move(Board board, Position sourcePosition, Position targetPosition) {
        if (!isInBoard(targetPosition)) {
            System.out.println("체스판 내에서만 이동할 수 있습니다.");
            return;
        }
        Piece piece = board.findPiece(sourcePosition);
        if (!piece.verifyMovePosition(sourcePosition, targetPosition)) {
            System.out.println("현재 선택한 기물은 해당 위치로 이동할 수 없습니다.");
            return;
        }
        Piece diePiece = board.findPiece(targetPosition);
        if (diePiece.getType().equals(Piece.Type.NO_PIECE)) {
            move(board, sourcePosition, diePiece);
        }
        else {
            move(board, sourcePosition, createBlank());
        }
        move(board, targetPosition, piece);
    }

    private static boolean isInBoard(Position targetPosition) {
        return 0 <= targetPosition.getX() && targetPosition.getX() < 8
                && 0 <= targetPosition.getY() && targetPosition.getY() < 8;
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
