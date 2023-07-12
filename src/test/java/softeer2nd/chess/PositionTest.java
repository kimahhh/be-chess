package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("좌표를 String으로 입력받아 생성할 수 있어야 한다")
    public void create() {
        Position position = new Position("b7");
        assertEquals(1, position.getX());
        assertEquals(1, position.getY());
    }
}