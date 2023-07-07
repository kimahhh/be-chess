package softeer2nd.chess.pieces;

import java.util.Objects;

public class Piece {
    public enum Color {
        WHITE, BLACK, NO_COLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private final char representation;
        private final double defaultPoint;
        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
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

    public static Piece createPiece(char representation) {
        boolean isBlack = Character.isUpperCase(representation);
        representation = Character.toLowerCase(representation);
        for (Type type : Type.values()) {
            if (representation == type.representation) {
                return type == Type.NO_PIECE ? createBlank() : createPiece(isBlack ? Color.BLACK : Color.WHITE, type);
            }
        }
        throw new IllegalArgumentException("잘못된 식별 문자 입니다");
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
    public double getPoint() {
        return type.defaultPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color.equals(piece.getColor()) &&
                type.equals(piece.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }
}
