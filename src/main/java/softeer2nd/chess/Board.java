package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

import static softeer2nd.utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_SIZE = 8;
    private static final int EMPTY_ROW_NUM = 6;
    private ArrayList<ArrayList<Object>> board;
    private ArrayList<Piece> Pawns;

    public Board() {
        board = new ArrayList<>();
        Pawns = new ArrayList<>();
    }

    public void add(Piece pawn) {
        Pawns.add(pawn);
    }

    public int size() {
        return Pawns.size();
    }

    public Piece findPawn(int index) {
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
            if (obj instanceof Piece) {
                Piece pawn = (Piece) obj;
                stringBuilder.append(pawn.getRepresentation());
            }
        }
        return stringBuilder.toString();
    }

    public void initialize() {
        Pawns.clear();
        ArrayList<Object> whitePawns = createPawns(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        ArrayList<Object> blackPawns = createPawns(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);

        initialBoard();
        addPawnsToBoard(1, blackPawns);
        addPawnsToBoard(6, whitePawns);
    }

    private ArrayList<Object> createPawns(String color, String representation) {
        ArrayList<Object> pawns = new ArrayList<>();
        for (int i = 0;i < BOARD_SIZE;i++) {
            Piece pawn = new Piece(color, representation);
            Pawns.add(pawn);
            pawns.add(pawn);
        }
        return pawns;
    }

    private ArrayList<Object> createEmptyRow() {
        ArrayList<Object> empty = new ArrayList<>();
        for (int i = 0;i < BOARD_SIZE;i++) {
            empty.add(".");
        }
        return empty;
    }

    private void initialBoard() {
        board.clear();
        ArrayList<Object> empty = createEmptyRow();
        for (int i = 0;i < EMPTY_ROW_NUM;i++) {
            board.add(empty);
        }
    }

    private void addPawnsToBoard(int index, ArrayList<Object> pawns) {
        board.add(index, pawns);
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList<Object> line: board) {
            for (Object obj : line) {
                if (obj instanceof Piece) {
                    Piece pawn = (Piece) obj;
                    stringBuilder.append(pawn.getRepresentation());
                }
                else {
                    stringBuilder.append(obj);
                }
            }
            appendNewLine(stringBuilder);
        }
        return stringBuilder.toString();
    }
}
