package softeer2nd.chess.Board;

import softeer2nd.chess.Rank;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import static softeer2nd.chess.Position.*;
import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class Board {
    public static final int BOARD_SIZE = 8;
    private ArrayList<Rank> board;

    public Board() {
        board = new ArrayList<>();
    }

    public int pieceCount() {
        return (int) board.stream()
                .flatMap(rank -> rank.rank.stream())
                .filter(piece -> !piece.getType().equals(Type.NO_PIECE))
                .count();
    }

    public int pieceCount(Color color, Type type) {
        return (int) board.stream()
                .flatMap(rank -> rank.rank.stream())
                .filter(piece -> piece.getColor().equals(color) && piece.getType().equals(type))
                .count();
    }

    public ArrayList<Rank> getBoard() {
        return this.board;
    }

    public Piece findPiece(String coordinate) {
        int x = getX(coordinate.charAt(0));
        int y = BOARD_SIZE - getY(coordinate.charAt(1));
        return board.get(y).rank.get(x);
    }

    public void move(String position, Piece piece) {
        board.get(BOARD_SIZE - getY(position.charAt(1)))
             .rank.set(getX(position.charAt(0)), piece);
    }

    public void move(String sourcePosition, String targetPosition) {
        Piece piece = findPiece(sourcePosition);
        Piece diePiece = findPiece(targetPosition);
        if (diePiece.getType().equals(Type.NO_PIECE)) {
            move(sourcePosition, diePiece);
        }
        else {
            move(sourcePosition, createBlank());
        }
        move(targetPosition, piece);
    }

    public String getRankResult(int index) {
        index = BOARD_SIZE - index;
        StringBuilder stringBuilder = new StringBuilder();
        for (Piece piece : board.get(index).rank) {
            stringBuilder.append(piece.getRepresentation());
        }
        return stringBuilder.toString();
    }

    public void initialize(String boardString) {
        board.clear();
        for(int i = 0;i < BOARD_SIZE;i++) {
            Rank rank = new Rank();
            for (int j = 0;j < BOARD_SIZE;j++) {
                rank.rank.add(createPiece(boardString.charAt(i * BOARD_SIZE + j)));
            }
            board.add(rank);
        }
    }

    public void initializeBasic() {
        String basic = "RNBQKBNR" +
                "PPPPPPPP" +
                "........" +
                "........" +
                "........" +
                "........" +
                "pppppppp" +
                "rnbqkbnr";
        initialize(basic);
    }

    public void initializeEmpty() {
        String noPiece = "........" +
                "........" +
                "........" +
                "........" +
                "........" +
                "........" +
                "........" +
                "........";
        initialize(noPiece);
    }

    public String showBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Rank rank: board) {
            for (Piece piece : rank.rank) {
                stringBuilder.append(piece.getRepresentation());
            }
            appendNewLine(stringBuilder);
        }
        return stringBuilder.toString();
    }

    public String showBoardWithXY() {
        StringBuilder stringBuilder = new StringBuilder();
        int y = 8;
        for (Rank rank: board) {
            for (Piece piece : rank.rank) {
                stringBuilder.append(piece.getRepresentation());
            }
            stringBuilder.append("  ").append(y--);
            appendNewLine(stringBuilder);
        }
        stringBuilder.append("abcdefgh");
        appendNewLine(stringBuilder);
        return stringBuilder.toString();
    }

    public double calculatePoint(Color color) {
        return board.stream()
                .flatMap(rank -> rank.rank.stream())
                .filter(piece -> piece.getColor().equals(color))
                .mapToDouble(Piece::getPoint)
                .sum() - countSameLinePawn(color) * 0.5;
    }

    private int countSameLinePawn(Color color) {
        int num = 0;
        for (int x = 0;x < BOARD_SIZE;x++) {
            int cnt = 0;
            for (Rank rank : board) {
                Piece piece = rank.rank.get(x);
                if (piece.getType().equals(Type.PAWN) && piece.getColor().equals(color)) {
                    cnt++;
                }
            }
            if (cnt >= 2) {
                num += cnt;
            }
        }
        return num;
    }

    public ArrayList<Piece> sortAscPieces(Color color) {
        return board.stream()
                .flatMap(rank -> rank.rank.stream())
                .filter(piece -> piece.getColor().equals(color))
                .sorted(Comparator.comparingDouble(Piece::getPoint))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Piece> sortDescPieces(Color color) {
        return board.stream()
                .flatMap(rank -> rank.rank.stream())
                .filter(piece -> piece.getColor().equals(color))
                .sorted(Comparator.comparingDouble(Piece::getPoint).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
