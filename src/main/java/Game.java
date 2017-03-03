import java.io.PrintStream;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Game {
    private Board board;
    private PrintStream out;

    public Game(Board board, PrintStream out) {
        this.board = board;
        this.out = out;
    }

    public void play() {
        out.println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }
}
