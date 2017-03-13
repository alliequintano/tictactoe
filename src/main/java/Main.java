import java.io.*;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(out, "1|2|3\n-----\n4|5|6\n-----\n7|8|9");
        Player player1 = new Player(out, in, "X");
        Player player2 = new Player(out, in, "O");
        Game game = new Game(board, player1, player2);

        game.play();
    }
}
