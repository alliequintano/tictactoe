import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private PrintStream out;
    private List<String> cells = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));

    public Board(PrintStream out) {
        this.out = out;
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
        for (int i = 1; i <= cells.size(); i++) {
            if (cellIsNotTaken("" + i)) return false;
        }
        return true;
    }

    public boolean hasThreeInARow() {
        for (int i = 0; i < cells.size(); i = i+3) {
            if (cells.get(i).equals(cells.get(i + 1)) && cells.get(i).equals(cells.get(i + 2))) {
                return true;
            }
        }
        return false;
    }
}
