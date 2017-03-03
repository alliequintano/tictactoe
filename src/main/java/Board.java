import java.io.PrintStream;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Board {
    private PrintStream out;

    public Board(PrintStream out) {

        this.out = out;
    }

    public void printBoard() {
        out.println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }
}
