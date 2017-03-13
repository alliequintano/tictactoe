import java.io.PrintStream;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Board {
    private PrintStream out;
    private final String cells;

    public Board(PrintStream out, String cells) {
        this.out = out;
        this.cells = cells;
    }

    public void printBoard() {
        out.println(cells);
    }

    public String addPlayerSymbolToBoard(String move, String symbol) {
        String updatedCells = cells.replace(move, symbol);
        return updatedCells;
    }
}
