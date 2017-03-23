import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private PrintStream out;
    private List<String> cells;
    private List<String> initialCells;

    public Board(PrintStream out, List<String> initialCells) {
        this.out = out;
        this.initialCells = initialCells;
        cells = new ArrayList<String>(initialCells);
    }

    public List<String> cells() {
        return cells;
    }

    public void printBoard() {
        String board = "";
        for (int i = 0; i < cells.size(); i++) {
            board += cells.get(i);
        }
        out.println(board);
    }

    public void addPlayerSymbolToBoard(String move, String symbol) {
        if (cellIsNotTaken(move)) {
            cells.set(cells.indexOf(move), cells.get(cells.indexOf(move)).replace(move, symbol));
        }
    }

    private boolean cellIsNotTaken(String move) {
        return cells.indexOf(move) != -1;
    }

    public boolean isFull() {
        for (int i = 0; i < cells.size(); i++) {
            if (cellIsNotTaken(initialCells.get(i))) return false;
        }
        return true;
    }
}
