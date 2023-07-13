package softeer2nd.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static softeer2nd.exception.Exception.*;

public class Position {
    private int x;
    private int y;

    public Position(String coordinate) {
        List<Integer> validPosition = verifyValidPosition(coordinate);
        x = validPosition.get(0);
        y = 8 - validPosition.get(1);
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

    private List<Integer> verifyValidPosition(String coordinate) {
        if (coordinate.length() != 2) {
            throw new IllegalArgumentException(POSITION_WRONG_LENGTH.getMessage());
        }
        char column = coordinate.charAt(0);
        char row = coordinate.charAt(1);

        if (column < 'a' || column > 'h') {
            throw new IllegalArgumentException(POSITION_WRONG_COLUMN.getMessage());
        }
        if (row < '1' || row > '8') {
            throw new IllegalArgumentException(POSITION_WRONG_ROW.getMessage());
        }
        return new ArrayList<>(Arrays.asList(char2int(column), numChar2int(row)));
    }
}
