import java.io.PrintStream;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream out = new PrintStream(System.out);
        Board board = new Board(out);
        Game game = new Game(board);

        game.play();
    }
}
