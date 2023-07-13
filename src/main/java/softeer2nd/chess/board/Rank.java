package softeer2nd.chess.board;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rank {
    private final ArrayList<Piece> rank = new ArrayList<>();

    public List<Piece> getRank() {
        return Collections.unmodifiableList(rank);
    }

    public Piece getPiece(int x) {
        return rank.get(x);
    }

    public void addPiece(Piece piece) {
        rank.add(piece);
    }

    public void setPiece(int x, Piece piece) {
        rank.set(x, piece);
    }
}
