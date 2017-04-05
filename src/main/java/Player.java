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

    public void makeMove() {
        out.println(name + " Select position on board: ");
        String move = readLine();
        while (board.cellIsTaken(move)) {
            out.println("Already taken. Enter a different move: ");
            move = readLine();
        }

        board.addPlayerSymbolToBoard(move, symbol);
    }

    private String readLine() {
        String string = "";
        try {
            string = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public void printPlayerWonMessage() {
        out.println(name + " Wins!");
    }
}
