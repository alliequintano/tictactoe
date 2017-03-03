import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Player {
    private Board board;
    private PrintStream out;

    public Player(Board board, PrintStream out) {

        this.board = board;
        this.out = out;
    }

    public void makeMove() throws IOException {
        out.println("Select position on board: ");

    }
}
