package softeer2nd.chess;

public class Position {
    private int x;
    private int y;

    public Position(String coordinate) {
        x = char2int(coordinate.charAt(0));
        y = 8 - numChar2int(coordinate.charAt(1));
    }

    private int char2int(char x) {
        return x - 'a';
    }

    private int numChar2int(char y) {
        return Character.getNumericValue(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
