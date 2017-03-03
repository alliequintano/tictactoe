import java.io.PrintStream;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void play() {
        board.printBoard();
    }
}
