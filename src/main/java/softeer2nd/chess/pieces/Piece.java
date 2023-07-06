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

    private final Color color;
    private final Type type;

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
        switch (color) {
            case WHITE:
                return createWhite(type);
            case BLACK:
                return createBlack(type);
            default:
                throw new IllegalArgumentException("색깔이 적절하지 않습니다.");
        }
    }

    private static Piece createWhite(Type type) {
        switch (type) {
            case KING:
                return King.createWhiteKing();
            case QUEEN:
                return Queen.createWhiteQueen();
            case ROOK:
                return Rook.createWhiteRook();
            case BISHOP:
                return Bishop.createWhiteBishop();
            case KNIGHT:
                return Knight.createWhiteKnight();
            case PAWN:
                return Pawn.createWhitePawn();
            default:
                throw new IllegalArgumentException("백색 기물 생성: 종류가 적절하지 않습니다.");
        }
    }

    private static Piece createBlack(Type type) {
        switch (type) {
            case KING:
                return King.createBlackKing();
            case QUEEN:
                return Queen.createBlackQueen();
            case ROOK:
                return Rook.createBlackRook();
            case BISHOP:
                return Bishop.createBlackBishop();
            case KNIGHT:
                return Knight.createBlackKnight();
            case PAWN:
                return Pawn.createBlackPawn();
            default:
                throw new IllegalArgumentException("흑색 기물 생성: 종류가 적절하지 않습니다.");
        }
    }

    public boolean isBlack() {
        return this.color.equals(Color.BLACK);
    }
    public boolean isWhite() {
        return this.color.equals(Color.WHITE);
    }

    public Color getColor() {
        return this.color;
    }
    public Type getType() {
        return this.type;
    }
    public char getRepresentation() {
        switch (this.color) {
            case WHITE:
            case NO_COLOR:
                return type.getWhiteRepresentation();
            case BLACK:
                return type.getBlackRepresentation();
            default:
                throw new IllegalArgumentException("색깔이 적절하지 않습니다.");
        }
    }
}
