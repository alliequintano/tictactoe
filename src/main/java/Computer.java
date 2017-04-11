import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer implements Player {
    private PrintStream out;
    private BufferedReader in;
    private String symbol;
    private Board board;

    public Computer(PrintStream out, BufferedReader in, String symbol, Board board) {
        this.out = out;
        this.in = in;
        this.symbol = symbol;
        this.board = board;
    }

    public void makeMove() {
        List<String> moves = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        int index = 0;
        String move = moves.get(index);

        while (board.cellIsTaken(move)) {
            move = moves.get(index++);
        }

        board.addPlayerSymbolToBoard(move, symbol);
    }

    public void printPlayerWonMessage() {

    }

}
