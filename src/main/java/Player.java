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
        boolean moveMade = false;

        while (!moveMade) {
            out.println(this.name + " Select position on board: ");
            move = in.readLine();
            if (!board.cells().contains(move)) {
                out.println("Already taken.");
            } else {
                board.addPlayerSymbolToBoard(move, symbol);
                moveMade = true;
            }
        }

        board.printBoard();
    }
}
