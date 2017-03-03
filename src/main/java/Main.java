import java.io.*;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(System.out);
        Board board = new Board(out);
        Player player = new Player(board, out);
        Game game = new Game(board, player);

        game.play();
    }
}
