package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Object>> board;
    private ArrayList<Pawn> Pawns;

    public Board() {
        board = new ArrayList<>();
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

    public String getBlackPawnsResult() {
        return getPawnsResult(1);
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(6);
    }

    public String getPawnsResult(int index) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object obj : board.get(index)) {
            if (obj instanceof Pawn) {
                Pawn pawn = (Pawn) obj;
                stringBuilder.append(pawn.getRepresentation());
            }
        }
        return stringBuilder.toString();
    }

    public void initialize() {
        Pawns.clear();
        ArrayList<Object> whitePawns = new ArrayList<>();
        ArrayList<Object> blackPawns = new ArrayList<>();
        for (int i = 0;i < 8;i++) {
            Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
            Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
            Pawns.add(white);
            whitePawns.add(white);
            Pawns.add(black);
            blackPawns.add(black);
        }

        board.clear();
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0;i < 8;i++) {
            objects.add(".");
        }
        for (int i = 0;i < 6;i++) {
            board.add(objects);
        }

        board.add(1, blackPawns);
        board.add(6, whitePawns);
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList<Object> line: board) {
            for (Object obj : line) {
                if (obj instanceof Pawn) {
                    Pawn pawn = (Pawn) obj;
                    stringBuilder.append(pawn.getRepresentation());
                }
                else {
                    stringBuilder.append(obj);
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
