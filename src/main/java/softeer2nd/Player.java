package softeer2nd;

import softeer2nd.chess.Board.Board;

import java.util.Scanner;

public class Player {
    private static boolean isStart = false;
    private static boolean isContinue = true;
    private static Board board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'Start' to begin the game");
        while(isContinue) {
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
                if (command.startsWith("move")) {
                    if (!isStart) {
                        System.out.println("아직 게임이 시작하지 않았습니다");
                        return;
                    }
                    movePiece(command);
                }
                else {
                    System.out.println("적절한 명령어를 입력해주세요");
                }
        }
    }

    private static void startGame() {
        System.out.println("Game is start");
        isStart = true;
        board = new Board();
        board.initializeBasic();
        System.out.println(board.showBoardWithXY());
    }

    private static void endGame() {
        isContinue = false;
        System.out.println("Game is end");
    }

    private static void movePiece(String command) {
        String[] commands = command.split(" ");
        board.move(commands[1], commands[2]);
        System.out.println(board.showBoardWithXY());
    }
}
