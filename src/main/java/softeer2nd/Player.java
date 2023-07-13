package softeer2nd;

import softeer2nd.chess.Board.Board;
import softeer2nd.chess.Board.ChessGame;
import softeer2nd.chess.Board.ChessView;
import softeer2nd.chess.Position;

import java.util.Scanner;

import static softeer2nd.chess.Board.ChessGame.move;

public class Player {
    private static boolean isStart = false;
    private static boolean isContinue = true;
    private static Board board;
    private static ChessView chessView;
    private static ChessGame chessGame;

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
        chessView = new ChessView();
        chessGame = new ChessGame();
        chessGame.initializeBasic(board);
        System.out.println(chessView.showBoardWithXY(board));
    }

    private static void endGame() {
        isContinue = false;
        System.out.println("Game is end");
    }

    private static void movePiece(String command) {
        String[] commands = command.split(" ");
        try {
            move(board, new Position(commands[1]), new Position(commands[2]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(chessView.showBoardWithXY(board));
    }
}
