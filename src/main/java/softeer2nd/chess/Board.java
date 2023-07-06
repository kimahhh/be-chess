package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;

import static softeer2nd.chess.Position.*;
import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_SIZE = 8;
    private static final int EMPTY_ROW_NUM = 4;
    private ArrayList<Rank> board;
    private ArrayList<Piece> pieces;

    public Board() {
        board = new ArrayList<>();
        pieces = new ArrayList<>();
    }

    public void add(Piece pawn) {
        pieces.add(pawn);
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

    public Piece getPiece(String coordinate) {
        int x = getX(coordinate.charAt(0));
        int y = 8 - getY(coordinate.charAt(1));
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

    public void initialize() {
        pieces.clear();
        Rank blackPieces = createPiecesRank(Color.BLACK);
        Rank blackPawns = createPawnsRank(Color.BLACK);
        Rank whitePawns = createPawnsRank(Color.WHITE);
        Rank whitePieces = createPiecesRank(Color.WHITE);

        initialBoard();
        addPiecesToBoard(0, blackPieces);
        addPiecesToBoard(1, blackPawns);
        addPiecesToBoard(6, whitePawns);
        addPiecesToBoard(7, whitePieces);
    }

    private Rank createPawnsRank(Color color) {
        Rank localPawns = new Rank();
        for (int i = 0;i < BOARD_SIZE;i++) {
            Piece piece = createPiece(color, Type.PAWN);
            pieces.add(piece);
            localPawns.rank.add(piece);
        }
        return localPawns;
    }

    private Rank createPiecesRank(Color color) {
        Rank localPieces = new Rank();
        Type[] typeNames = new Type[]{Type.ROOK, Type.KNIGHT, Type.BISHOP, Type.QUEEN, Type.KING, Type.BISHOP, Type.KNIGHT, Type.ROOK};
        for (Type type : typeNames) {
            Piece piece = createPiece(color, type);
            pieces.add(piece);
            localPieces.rank.add(piece);
        }
        return localPieces;
    }

    private Rank createEmptyRank() {
        Rank empty = new Rank();
        for (int i = 0;i < BOARD_SIZE;i++) {
            empty.rank.add(createBlank());
        }
        return empty;
    }

    private void initialBoard() {
        board.clear();
        Rank empty = createEmptyRank();
        for (int i = 0;i < EMPTY_ROW_NUM;i++) {
            board.add(empty);
        }
    }

    private void addPiecesToBoard(int index, Rank pawns) {
        board.add(index, pawns);
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
