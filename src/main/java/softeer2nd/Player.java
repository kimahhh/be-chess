package softeer2nd;

import softeer2nd.chess.board.Board;
import softeer2nd.chess.board.ChessGame;
import softeer2nd.chess.board.ChessView;
import softeer2nd.chess.Position;

import java.util.Scanner;

import static softeer2nd.chess.board.ChessGame.isWhiteTurn;
import static softeer2nd.chess.board.ChessGame.move;

public class Player {
    private static boolean isStart = false;
    private static boolean isContinue = true;
    private static Board board;
    private static ChessView chessView;
    private static ChessGame chessGame;
    private static final String ENTER_START = "Enter 'Start' to begin the game";
    private static final String COMMAND_INFO = "Command List:\n1. move a3 d5 2. resigns 3. end";
    private static final String NOT_START_YET = "아직 게임이 시작하지 않았습니다.";
    private static final String RIGHT_COMMAND = "적절한 명령어를 입력해주세요.";
    private static final String GAME_IS_START = "Game is start";
    private static final String GAME_IS_END = "Game is end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_START);
        while(isContinue) {
            if (isStart) {
                System.out.println(COMMAND_INFO);
            }
            String command = scanner.nextLine();
            gameAction(command.toLowerCase());
        }
    }

    private static void gameAction(String command) {
        switch (command) {
            case "start":
                startGame();
                break;
            case "end":
                endGame();
                break;
            default:
                if (!isStart) {
                    System.out.println(NOT_START_YET);
                    return;
                }
                if (command.startsWith("move")) {
                    movePiece(command);
                }
                else if (command.equals("resigns")) {
                    resignGame();
                }
                else {
                    System.out.println(RIGHT_COMMAND);
                }
        }
    }

    private static void startGame() {
        System.out.println(GAME_IS_START);
        isStart = true;
        board = new Board();
        chessView = new ChessView();
        chessGame = new ChessGame();
        chessGame.initializeBasic(board);
        System.out.println(chessView.showBoardWithXY(board));
    }

    private static void endGame() {
        isContinue = false;
        System.out.println(GAME_IS_END);
    }

    private static void resignGame() {
        System.out.println(isWhiteTurn ? "Black Win!" : "White Win!");
        endGame();
    }

    private static void movePiece(String command) {
        String[] commands = command.split(" ");
        try {
            move(board, new Position(commands[1]), new Position(commands[2]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e.getMessage().endsWith("승리했습니다.")) {
                endGame();
            }
        }
        System.out.println(chessView.showBoardWithXY(board));
    }
}
