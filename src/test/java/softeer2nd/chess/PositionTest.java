package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.exception.Exception.*;

class PositionTest {

    @Test
    @DisplayName("위치를 String으로 입력받아 생성할 수 있어야 한다")
    void create() {
        Position position = new Position("b7");
        assertEquals(1, position.getX());
        assertEquals(1, position.getY());
    }

    @Test
    @DisplayName("잘못된 위치를 입력받으면 오류를 던져야 한다")
    void createPositionException() {
        verifyPosition("ab3");
        verifyPosition("z3");
        verifyPosition("a9");
    }

    private void verifyPosition(String coordinate) {
        Exception exception = assertThrows(Exception.class, () -> {
            new Position(coordinate);
        });

        assertEquals(POSITION_WRONG_INPUT.getMessage(), exception.getMessage());
    }

}