package softeer2nd;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> Pawns;

    public Board() {
        Pawns = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        Pawns.add(pawn);
    }

    public int size() {
        return Pawns.size();
    }

    public Pawn findPawn(int index) {
        return Pawns.get(index);
    }
}
