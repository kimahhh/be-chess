package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import java.util.List;
import java.util.Objects;

import static softeer2nd.exception.Exception.*;

public abstract class Piece {
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
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }
    }

    private final Color color;
    private final Type type;

    private Piece() {
        color = Color.NO_COLOR;
        type = Type.NO_PIECE;
    }

    protected Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public abstract boolean verifyMovePosition(Position sourcePosition, Position targetPosition);
    public abstract List<Position> verifyPathClear(Position sourcePosition, Position targetPosition);

    public static Piece createBlank() {
        return Blank.createBlank();
    }

    public static Piece createPiece(Color color, Type type) {
        switch (color) {
            case WHITE:
                return createWhite(type);
            case BLACK:
                return createBlack(type);
            default:
                throw new IllegalArgumentException(PIECE_INVALID_COLOR.getMessage());
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
        throw new IllegalArgumentException(PIECE_INVALID_REPRESENTATION.getMessage());
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
                throw new IllegalArgumentException(PIECE_INVALID_TYPE.getMessage());
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
                throw new IllegalArgumentException(PIECE_INVALID_TYPE.getMessage());
        }
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }
    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }
    public boolean isEmpty() {
        return type.equals(Type.NO_PIECE);
    }

    public Color getColor() {
        return color;
    }
    public Type getType() {
        return type;
    }
    public char getRepresentation() {
        switch (color) {
            case WHITE:
            case NO_COLOR:
                return type.getWhiteRepresentation();
            case BLACK:
                return type.getBlackRepresentation();
            default:
                throw new IllegalArgumentException(PIECE_INVALID_COLOR.getMessage());
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
