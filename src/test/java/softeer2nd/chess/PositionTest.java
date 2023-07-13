package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Board.ChessGame.move;
import static softeer2nd.exception.Exception.*;

class PositionTest {

    @Test
    @DisplayName("좌표를 String으로 입력받아 생성할 수 있어야 한다")
    void create() {
        Position position = new Position("b7");
        assertEquals(1, position.getX());
        assertEquals(1, position.getY());
    }

    @Test
    @DisplayName("입력받은 좌표의 길이가 2가 아니라면 POSITION_WRONG_LENGTH 오류를 던져야 한다")
    void throwWrongLengthException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Position("ab3");
        });

        assertEquals(POSITION_WRONG_LENGTH.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력받은 좌표의 열이 a~h 사이 값이 아니라면 POSITION_WRONG_COLUMN 오류를 던져야 한다")
    void throwWrongColumnException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Position("z3");
        });

        assertEquals(POSITION_WRONG_COLUMN.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력받은 좌표의 행이 1~8 사이 값이 아니라면 POSITION_WRONG_ROW 오류를 던져야 한다")
    void throwWrongRowException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Position("c9");
        });

        assertEquals(POSITION_WRONG_ROW.getMessage(), exception.getMessage());
    }

}