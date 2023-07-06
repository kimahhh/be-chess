package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Position.*;

class PositionTest {

    @Test
    @DisplayName("char 알파벳을 입력받아 int로 반환할 수 있어야 한다")
    public void charAlphabetToInt() {
        assertEquals(0, getX('a'));
        assertEquals(5, getX('f'));
    }

    @Test
    @DisplayName("char 숫자를 입력받아 int로 반환할 수 있어야 한다")
    public void charNumToInt() {
        assertEquals(0, getY('0'));
        assertEquals(5, getY('5'));
    }
}