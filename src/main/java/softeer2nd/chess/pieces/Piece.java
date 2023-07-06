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

    private Piece() {
        this.color = Color.NO_COLOR;
        this.type = Type.NO_PIECE;
    }

    protected Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createBlank() {
        return new Piece();
    }

    public static Piece createPiece(Color color, Type type) {
        switch (type) {
            case KING:
                return color.equals(Color.WHITE) ? King.createWhiteKing() : King.createBlackKing();
            case QUEEN:
                return color.equals(Color.WHITE) ? Queen.createWhiteQueen() : Queen.createBlackQueen();
            case ROOK:
                return color.equals(Color.WHITE) ? Rook.createWhiteRook() : Rook.createBlackRook();
            case BISHOP:
                return color.equals(Color.WHITE) ? Bishop.createWhiteBishop() : Bishop.createBlackBishop();
            case KNIGHT:
                return color.equals(Color.WHITE) ? Knight.createWhiteKnight() : Knight.createBlackKnight();
            case PAWN:
                return color.equals(Color.WHITE) ? Pawn.createWhitePawn() : Pawn.createBlackPawn();
            default:
                throw new IllegalArgumentException("색깔과 종류가 적절하지 않습니다.");
        }
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
