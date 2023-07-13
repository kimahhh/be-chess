package softeer2nd.chess.board;


import softeer2nd.chess.Position;
import softeer2nd.chess.pieces.Piece;

import static softeer2nd.chess.board.Board.BOARD_SIZE;
import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.exception.Exception.*;

public class ChessGame {
    public static boolean isWhiteTurn;

    public ChessGame() {
        isWhiteTurn = true;
    }

    public void initialize(Board board, String boardString) {
        board.getBoard().clear();
        for(int y = 0;y < BOARD_SIZE;y++) {
            Rank rank = new Rank();
            for (int x = 0;x < BOARD_SIZE;x++) {
                rank.addPiece(createPiece(boardString.charAt(y * BOARD_SIZE + x)));
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
                .setPiece(position.getX(), piece);
    }

    public static void move(Board board, Position sourcePosition, Position targetPosition) {
        checkSamePosition(sourcePosition, targetPosition);
        Piece piece = board.findPiece(sourcePosition);
        checkTurn(piece);
        checkMove(piece, sourcePosition, targetPosition);
        checkPath(board, piece, sourcePosition, targetPosition);
        Piece diePiece = board.findPiece(targetPosition);
        checkColor(piece, diePiece);
        if (diePiece.getType().equals(Piece.Type.NO_PIECE)) {
            move(board, sourcePosition, diePiece);
        }
        else {
            move(board, sourcePosition, createBlank());
        }
        move(board, targetPosition, piece);
        changeTurn();
    }

    private static void checkSamePosition(Position sourcePosition, Position targetPosition) {
        if (sourcePosition.equals(targetPosition))
            throw new IllegalArgumentException(POSITION_MOVE_TO_SAME_POSITION.getMessage());
    }

    private static void checkTurn(Piece piece) {
        if (isWhiteTurn == piece.isWhite()) return;
        throw new IllegalArgumentException((isWhiteTurn ? "흰" : "검은") + NOT_YOUR_TURN.getMessage());
    }

    private static void checkMove(Piece piece, Position sourcePosition, Position targetPosition) {
        if (!piece.verifyMovePosition(sourcePosition, targetPosition))
            throw new IllegalArgumentException(PIECE_INVALID_POSITION.getMessage());
    }

    private static void checkPath(Board board, Piece piece, Position sourcePosition, Position targetPosition) {
        for (Position position : piece.verifyPathClear(sourcePosition, targetPosition)) {
            if (!board.findPiece(position).equals(createBlank())) {
                throw new IllegalArgumentException(PIECE_INVALID_PATH.getMessage());
            }
        }
    }

    private static void checkColor(Piece sourcePiece, Piece targetPiece) {
        if (sourcePiece.isWhite() == targetPiece.isWhite() && sourcePiece.isBlack() == targetPiece.isBlack())
            throw new IllegalArgumentException(PIECE_CANT_CATCH_SAME_COLOR.getMessage());
    }

    private static void changeTurn() {
        isWhiteTurn = !isWhiteTurn;
    }

    public double calculatePoint(Board board, Color color) {
        return board.getBoard().stream()
                .flatMap(rank -> rank.getRank().stream())
                .filter(piece -> piece.getColor().equals(color))
                .mapToDouble(Piece::getPoint)
                .sum() - countSameLinePawn(board, color) * 0.5;
    }

    private int countSameLinePawn(Board board, Color color) {
        int num = 0;
        for (int x = 0;x < BOARD_SIZE;x++) {
            int cnt = 0;
            for (Rank rank : board.getBoard()) {
                Piece piece = rank.getPiece(x);
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
