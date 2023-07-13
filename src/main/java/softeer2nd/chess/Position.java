package softeer2nd.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static softeer2nd.exception.Exception.*;

public class Position {

    private String positionRegex = "[a-h][1-8]";
    private int x;
    private int y;

    public Position(String coordinate) {
        List<Integer> validPosition = verifyValidPosition(coordinate);
        x = validPosition.get(0);
        y = 8 - validPosition.get(1);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
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
        if (coordinate.matches(positionRegex))
            return new ArrayList<>(Arrays.asList(char2int(coordinate.charAt(0)), numChar2int(coordinate.charAt(1))));
        throw new IllegalArgumentException(POSITION_WRONG_INPUT.getMessage());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
