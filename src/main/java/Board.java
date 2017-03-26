import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private PrintStream out;
    private List<String> cells = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
    public Board(PrintStream out, List<String> cells) {
        this.out = out;
    }

    public List<String> cells() {
        return cells;
    }

    public void printBoard() {
        out.println(cells.get(0) + "|" + cells.get(1) + "|" + cells.get(2)
                    + "\n" + "-----\n" +
                    cells.get(3) + "|" + cells.get(4) + "|" + cells.get(5)
                    + "\n" + "-----\n" +
                    cells.get(6) + "|" + cells.get(7) + "|" + cells.get(8));
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
        for (int i = 0; i < cells.size(); i = i + 3) {
            if (cells.get(i).equals(cells.get(i + 1)) && cells.get(i).equals(cells.get(i + 2))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasThreeInAColumn() {
        for (int i = 0; i <= 3; i++) {
            if (cells.get(i).equals(cells.get(i + 3)) && cells.get(i).equals(cells.get(i + 6))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasThreeInADiagonal() {
        if ((cells.get(0).equals(cells.get(4)) && cells.get(0).equals(cells.get(8)))
            || (cells.get(2).equals(cells.get(4)) && cells.get(2).equals(cells.get(6)))) {
                return true;
        }
        return false;
    }
}
