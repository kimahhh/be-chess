package softeer2nd.chess;

public class Position {
    public static int getX(char x) {
        return x - 'a';
    }

    public static int getY(char y) {
        return Character.getNumericValue(y);
    }
}
