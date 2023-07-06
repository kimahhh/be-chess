package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

import static softeer2nd.chess.Position.*;
import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_SIZE = 8;
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

제    public Piece findPiece(String coordinate) {
        int x = getX(coordinate.charAt(0));
        int y = BOARD_SIZE - getY(coordinate.charAt(1));
        return board.get(y).rank.get(x);
    }

    public String getRankResult(int index) {
        index = 8 - index;
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
}
