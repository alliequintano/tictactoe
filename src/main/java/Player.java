import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Player {
    private PrintStream out;
    private BufferedReader in;
    private String symbol;
    private Board board;

    public Player(PrintStream out, BufferedReader in, String symbol, Board board) {
        this.out = out;
        this.in = in;
        this.symbol = symbol;
        this.board = board;
    }

    public void makeMove() throws IOException {
        String move;
        boolean moveMade = false;

        while (!moveMade) {
            out.println("Select position on board: ");
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
