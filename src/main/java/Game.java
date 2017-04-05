import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private PrintStream out;
    private String winnerMessage;
    private Player currentPlayer;

    public Game(Board board, Player player1, Player player2, PrintStream out) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.out = out;
        currentPlayer = player1;
    }

    public void play() {
        board.printBoard();

        do {
            currentPlayer.makeMove();
            nextPlayer();
        } while (!gameIsOver());

        printWinnerMessage();
    }

    private boolean gameIsOver() {
        return board.hasWinner() || board.isFull();
    }

    private void nextPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private void printWinnerMessage() {
        if (board.isFull()) {
            out.println("Game is a draw.");
        } else {
            // this should be simpler
            if (currentPlayer == player1) {
                player2.printPlayerWonMessage();
            } else {
                player1.printPlayerWonMessage();
            }
        }
    }

}
