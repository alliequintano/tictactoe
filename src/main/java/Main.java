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
        Player player1 = new Human(out, in, "X", board, "Human 1");
        Player player2 = new Computer(out, in, "O", board);
        Game game = new Game(board, player1, player2, out);

        game.play();
    }
}
