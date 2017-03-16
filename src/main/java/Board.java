import java.io.PrintStream;
import java.util.List;

public class Board {
    private PrintStream out;
    private List<String> cells;

    public Board(PrintStream out, List<String> cells) {
        this.out = out;
        this.cells = cells;
    }

    public void printBoard() {
        String board = "";
        for (int i = 0; i < cells.size(); i++) {
            board += cells.get(i);
        }
        out.println(board);
    }

    public List<String> addPlayerSymbolToBoard(String move, String symbol) {
        if (!cellIsTaken(move)) {
            cells.set(cells.indexOf(move), cells.get(cells.indexOf(move)).replace(move, symbol));
        }
        return cells;
    }

    private boolean cellIsTaken(String move) {
        return cells.indexOf(move) == -1;
    }
}
