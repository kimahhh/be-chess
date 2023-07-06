package softeer2nd.chess.pieces;

public class Piece {
    public enum Color {
        WHITE, BLACK, NO_COLOR;
    }

    public enum Type {
        PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'),
        QUEEN('q'), KING('k'), NO_PIECE('o');

        private char representation;
        Type(char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }
    }

    private Color color;
    private Type type;

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
