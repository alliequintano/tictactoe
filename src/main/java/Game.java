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
    }

    public void play() throws IOException {
        do {
            nextPlayer();
            currentPlayer.makeMove();
        } while (!gameIsOver());

        board.printBoard();
        printWinnerMessage();
    }

    private boolean gameIsOver() {
        if (board.hasThreeInARow() || board.hasThreeInAColumn()) {
            winnerMessage = currentPlayer.name() + " Wins!";
            return true;
        }
        else if (board.isFull()) {
            winnerMessage = "Game is a draw.";
            return true;
        }
        return false;
    }

    private void nextPlayer() {
        if (currentPlayer == null) {
            currentPlayer = player1;
        }
        else if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private void printWinnerMessage() {
        out.println(winnerMessage);
    }

}
