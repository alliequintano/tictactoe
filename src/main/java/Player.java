import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Player {
    private PrintStream out;
    private BufferedReader in;

    public Player(PrintStream out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    public Board makeMove(Board board) throws IOException {
        out.println("Select position on board: ");
        String move = in.readLine();

        return board.addToBoard(move);
    }
}
