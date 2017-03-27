import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Player {
    private PrintStream out;
    private BufferedReader in;
    private String symbol;
    private Board board;
    private String name;

    public Player(PrintStream out, BufferedReader in, String symbol, Board board, String name) {
        this.out = out;
        this.in = in;
        this.symbol = symbol;
        this.board = board;
        this.name = name;
    }

    public void makeMove() throws IOException {
        String move;
        out.println(name + " Select position on board: ");
        move = in.readLine();

        while (board.cellIsTaken(move)) {
            out.println("Already taken. Enter a different move: ");
            move = in.readLine();
        }

        board.addPlayerSymbolToBoard(move, symbol);
    }

    public String name() {
        return this.name;
    }
}
