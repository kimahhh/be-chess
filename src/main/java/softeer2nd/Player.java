package softeer2nd;

import softeer2nd.chess.Board;

import java.util.Scanner;

public class Player {
    private static boolean isContinue = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'Start' to begin the game");
        while(isContinue) {
            String command = scanner.nextLine();
            command = command.toLowerCase();
            gameAction(command);
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
        }
    }

    private static void startGame() {
        System.out.println("Game is start");
        Board board = new Board();
        board.initialize();
        System.out.println(board.print());
    }

    private static void endGame() {
        isContinue = false;
        System.out.println("Game is end");
    }
}
