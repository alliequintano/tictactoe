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

    public Game(Board board, Player player1, Player player2, PrintStream out) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.out = out;
    }

    public void play() throws IOException {
        while (!board.isFull()) {
            player1.makeMove();

            if (!board.isFull()) {
                player2.makeMove();
            }
        }
        board.printBoard();
        out.println("Game is a draw.");
    }

}
