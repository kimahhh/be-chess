package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.Piece.ROOK;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_SIZE = 8;
    private static final int EMPTY_ROW_NUM = 4;
    private ArrayList<ArrayList<Object>> board;
    private ArrayList<Piece> pieces;

    public Board() {
        board = new ArrayList<>();
        pieces = new ArrayList<>();
    }

    public void add(Piece pawn) {
        pieces.add(pawn);
    }

    public int pieceCount() {
        return pieces.size();
    }

    public Piece findPawn(int index) {
        return pieces.get(index);
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
        pieces.clear();
        ArrayList<Object> blackPieces = createPieces(Piece.BLACK_COLOR);
        ArrayList<Object> blackPawns = createPawns(Piece.BLACK_COLOR, Piece.PAWN);
        ArrayList<Object> whitePawns = createPawns(Piece.WHITE_COLOR, Piece.PAWN);
        ArrayList<Object> whitePieces = createPieces(WHITE_COLOR);

        initialBoard();
        addPiecesToBoard(0, blackPieces);
        addPiecesToBoard(1, blackPawns);
        addPiecesToBoard(6, whitePawns);
        addPiecesToBoard(7, whitePieces);
    }

    private ArrayList<Object> createPawns(String color, String name) {
        ArrayList<Object> localPawns = new ArrayList<>();
        for (int i = 0;i < BOARD_SIZE;i++) {
            Piece piece = null;
            if (color.equals(Piece.WHITE_COLOR)) {
                piece = createWhitePawn();
            }
            else if (color.equals(Piece.BLACK_COLOR)) {
                piece = createBlackPawn();
            }
            pieces.add(piece);
            localPawns.add(piece);
        }
        return localPawns;
    }

    private ArrayList<Object> createPieces(String color) {
        ArrayList<Object> localPieces = new ArrayList<>();
        String[] piecesName = new String[]{ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};
        for (String pieceName : piecesName) {
            Piece piece = createPiece(color, pieceName);
            pieces.add(piece);
            localPieces.add(piece);
        }
        return localPieces;
    }

    private Piece createPiece(String color, String name) {
        for (int i = 0;i < BOARD_SIZE;i++) {
            if (color.equals(Piece.WHITE_COLOR)) {
                switch (name) {
                    case KING:
                        return createWhiteKing();
                    case QUEEN:
                        return createWhiteQueen();
                    case ROOK:
                        return createWhiteRook();
                    case BISHOP:
                        return createWhiteBishop();
                    case KNIGHT:
                        return createWhiteKnight();
                }
            }
            else if (color.equals(Piece.BLACK_COLOR)) {
                switch (name) {
                    case KING:
                        return createBlackKing();
                    case QUEEN:
                        return createBlackQueen();
                    case ROOK:
                        return createBlackRook();
                    case BISHOP:
                        return createBlackBishop();
                    case KNIGHT:
                        return createBlackKnight();
                }
            }
        }
        return null;
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

    private void addPiecesToBoard(int index, ArrayList<Object> pawns) {
        board.add(index, pawns);
    }

    public String showBoard() {
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
