package softeer2nd.exception;

public enum Exception {
    POSITION_WRONG_INPUT("위치값이 적절하지 않습니다. [a-h][1-8] 형식으로 입력해주세요."),
    POSITION_MOVE_TO_SAME_POSITION("같은 위치로는 이동할 수 없습니다."),
    PIECE_INVALID_POSITION("현재 선택한 기물은 해당 위치로 이동할 수 없습니다."),
    PIECE_INVALID_PATH("목적지로 가는 경로에 다른 기물이 있습니다."),
    PIECE_INVALID_COLOR("색깔이 적절하지 않습니다."),
    PIECE_INVALID_REPRESENTATION("식별 문자가 적절하지 않습니다."),
    PIECE_INVALID_TYPE("종류가 적절하지 않습니다."),
    PIECE_CANT_CATCH_SAME_COLOR("같은 색의 기물은 잡을 수 없습니다."),
    BLANK_CANT_MOVE("입력한 출발점에는 기물이 없습니다."),
    NOT_YOUR_TURN(" 색 기물이 움직일 차례입니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
