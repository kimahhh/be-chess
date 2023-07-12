package softeer2nd.chess.Board;

import softeer2nd.chess.Position;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import static softeer2nd.chess.pieces.Piece.*;

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
        Position position = new Position(coordinate);
        return board.get(position.getY()).rank.get(position.getX());
    }

    public String getRankResult(int index) {
        index = BOARD_SIZE - index;
        StringBuilder stringBuilder = new StringBuilder();
        for (Piece piece : board.get(index).rank) {
            stringBuilder.append(piece.getRepresentation());
        }
        return stringBuilder.toString();
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
