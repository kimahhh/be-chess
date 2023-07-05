package softeer2nd.chess.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String KING = "King";
    public static final char WHITE_KING_REPRESENTATION = 'k';
    public static final char BLACK_KING_REPRESENTATION = 'K';
    public static final String QUEEN = "Queen";
    public static final char WHITE_QUEEN_REPRESENTATION = 'q';
    public static final char BLACK_QUEEN_REPRESENTATION = 'Q';
    public static final String ROOK = "Rook";
    public static final char WHITE_ROOK_REPRESENTATION = 'r';
    public static final char BLACK_ROOK_REPRESENTATION = 'R';
    public static final String BISHOP = "Bishop";
    public static final char WHITE_BISHOP_REPRESENTATION = 'b';
    public static final char BLACK_BISHOP_REPRESENTATION = 'B';
    public static final String KNIGHT = "Knight";
    public static final char WHITE_KNIGHT_REPRESENTATION = 'n';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'N';
    public static final String PAWN = "Pawn";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';

    private String color;
    private String name;
    private char representation;

    private Piece(String color, String name) {
        this.color = color;
        this.name = name;

        if (color.equals(WHITE_COLOR)) {
            switch (name) {
                case KING:
                    this.representation = WHITE_KING_REPRESENTATION;
                    break;
                case QUEEN:
                    this.representation = WHITE_QUEEN_REPRESENTATION;
                    break;
                case ROOK:
                    this.representation = WHITE_ROOK_REPRESENTATION;
                    break;
                case BISHOP:
                    this.representation = WHITE_BISHOP_REPRESENTATION;
                    break;
                case KNIGHT:
                    this.representation = WHITE_KNIGHT_REPRESENTATION;
                    break;
                case PAWN:
                    this.representation = WHITE_PAWN_REPRESENTATION;
                    break;
            }

        } else if (color.equals(BLACK_COLOR)) {
            switch (name) {
                case KING:
                    this.representation = BLACK_KING_REPRESENTATION;
                    break;
                case QUEEN:
                    this.representation = BLACK_QUEEN_REPRESENTATION;
                    break;
                case ROOK:
                    this.representation = BLACK_ROOK_REPRESENTATION;
                    break;
                case BISHOP:
                    this.representation = BLACK_BISHOP_REPRESENTATION;
                    break;
                case KNIGHT:
                    this.representation = BLACK_KNIGHT_REPRESENTATION;
                    break;
                case PAWN:
                    this.representation = BLACK_PAWN_REPRESENTATION;
                    break;
            }
        }
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE_COLOR, KING);
    }
    public static Piece createBlackKing() {
        return new Piece(BLACK_COLOR, KING);
    }
    public static Piece createWhiteQueen() {
        return new Piece(WHITE_COLOR, QUEEN);
    }
    public static Piece createBlackQueen() {
        return new Piece(BLACK_COLOR, QUEEN);
    }
    public static Piece createWhiteRook() {
        return new Piece(WHITE_COLOR, ROOK);
    }
    public static Piece createBlackRook() {
        return new Piece(BLACK_COLOR, ROOK);
    }
    public static Piece createWhiteBishop() {
        return new Piece(WHITE_COLOR, BISHOP);
    }
    public static Piece createBlackBishop() {
        return new Piece(BLACK_COLOR, BISHOP);
    }
    public static Piece createWhiteKnight() {
        return new Piece(WHITE_COLOR, KNIGHT);
    }
    public static Piece createBlackKnight() {
        return new Piece(BLACK_COLOR, KNIGHT);
    }
    public static Piece createWhitePawn() {
        return new Piece(WHITE_COLOR, PAWN);
    }
    public static Piece createBlackPawn() {
        return new Piece(BLACK_COLOR, PAWN);
    }

    public boolean isBlack() {
        return this.color.equals(BLACK_COLOR);
    }
    public boolean isWhite() {
        return this.color.equals(WHITE_COLOR);
    }

    public String getColor() {
        return this.color;
    }
    public char getRepresentation() {
        return this.representation;
    }
}
