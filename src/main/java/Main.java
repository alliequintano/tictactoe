import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<String> cells = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        Board board = new Board(out, cells);
        Player player1 = new Player(out, in, "X", board, "Player 1");
        Player player2 = new Player(out, in, "O", board, "Player 2");
        Game game = new Game(board, player1, player2);

        game.play();
    }
}
