package softeer2nd.chess.board;

import softeer2nd.chess.pieces.Piece;

import static softeer2nd.utils.StringUtils.appendNewLine;

public class ChessView {
    public String showBoard(Board board) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Rank rank: board.getBoard()) {
            for (Piece piece : rank.rank) {
                stringBuilder.append(piece.getRepresentation());
            }
            appendNewLine(stringBuilder);
        }
        return stringBuilder.toString();
    }

    public String showBoardWithXY(Board board) {
        StringBuilder stringBuilder = new StringBuilder();
        int y = 8;
        for (Rank rank: board.getBoard()) {
            for (Piece piece : rank.rank) {
                stringBuilder.append(piece.getRepresentation());
            }
            stringBuilder.append("  ").append(y--);
            appendNewLine(stringBuilder);
        }
        stringBuilder.append("abcdefgh");
        appendNewLine(stringBuilder);
        return stringBuilder.toString();
    }
}
