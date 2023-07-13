package softeer2nd.exception;

public enum Exception {
    POSITION_WRONG_LENGTH("위치값은 알파벳 a~h 중 하나와 숫자 1~8 중 하나의 값으로 이루어져 있습니다."),
    POSITION_WRONG_COLUMN("열 값은 a~h 중 하나를 입력해주세요."),
    POSITION_WRONG_ROW("행 값은 1~8 중 하나를 입력해주세요."),
    PIECE_INVALID_POSITION("현재 선택한 기물은 해당 위치로 이동할 수 없습니다."),
    PIECE_INVALID_COLOR("색깔이 적절하지 않습니다."),
    PIECE_INVALID_REPRESENTATION("식별 문자가 적절하지 않습니다."),
    PIECE_INVALID_TYPE("종류가 적절하지 않습니다."),
    PIECE_CANT_CATCH_SAME_COLOR("같은 색의 기물은 잡을 수 없습니다."),
    BLANK_CANT_MOVE("입력한 출발점에는 기물이 없습니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
