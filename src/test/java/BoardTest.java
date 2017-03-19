import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {
    PrintStream out;
    List<String> cells;
    Board board;

    @Before
    public void setup() {
        out = mock(PrintStream.class);
        board = new Board(out, new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9")));
    }

    @Test
    public void shouldPrintBoard() {
        board.printBoard();

        verify(out).println("123456789");
    }

    @Test
    public void shouldAddMoveToBoardByMarkingMoveWithSymbol() {
        int cellIndex = board.cells().indexOf("3");
        board.addPlayerSymbolToBoard("3", "X");

        assertThat(board.cells().get(cellIndex), is("X"));
    }

    @Test
    public void shouldMakeMoveWithSecondPlayerSymbol() {
        int cellIndex = board.cells().indexOf("5");
        board.addPlayerSymbolToBoard("5", "O");

        assertThat(board.cells().get(cellIndex), is("O"));
    }

    @Test
    public void shouldNotAddMoveWhenAlreadyTaken() {
        int cellIndex = board.cells().indexOf("2");

        board = new Board(out, new ArrayList<String>(Arrays.asList("1","X","3","4","5","6","7","8","9")));
        board.addPlayerSymbolToBoard("2", "O");

        assertThat(board.cells().get(cellIndex), is("X"));
    }
}