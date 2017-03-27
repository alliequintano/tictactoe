import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BoardTest {
    private PrintStream out;
    private Board board;
    private List<String> cells;

    @Before
    public void setup() {
        out = mock(PrintStream.class);
        cells = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        board = new Board(out, cells);
    }

    @Test
    public void shouldPrintBoard() {
        board.printBoard();
        verify(out).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

    @Test
    public void shouldAddMoveToBoardByMarkingMoveWithSymbol() {
        board.addPlayerSymbolToBoard("3", "X");
        assertThat(cells.get(2), is("X"));
    }

    @Test
    public void shouldMakeMoveWithSecondPlayerSymbol() {
        board.addPlayerSymbolToBoard("5", "O");
        assertThat(cells.get(4), is("O"));
    }

    @Test
    public void shouldNotAddMoveWhenAlreadyTaken() {
        cells = new ArrayList<String>(Arrays.asList("1","X","3","4","5","6","7","8","9"));
        board = new Board(out, cells);
        board.addPlayerSymbolToBoard("2", "O");
        assertThat(cells.get(1), is("X"));
    }

    @Test
    public void shouldCheckIfAllCellsAreTaken() {
        cells = new ArrayList<String>(Arrays.asList("O","X","O","X","O","X","O","X","O"));
        board = new Board(out, cells);
        assertThat(board.isFull(), is(true));
    }

    @Test
    public void shouldCheckIfThreeOfSameSymbolsInARow() {
        cells = new ArrayList<String>(Arrays.asList("O","O","O","4","X","6","O","X","O"));
        board = new Board(out, cells);
        assertThat(board.hasThreeInARow(), is(true));
    }

    @Test
    public void shouldCheckIfThreeOfSameSymbolInColumn() {
        cells = new ArrayList<String>(Arrays.asList("1","X","3","4","X","6","7","X","9"));
        board = new Board(out, cells);
        assertThat(board.hasThreeInAColumn(), is(true));
    }

    @Test
    public void shouldCheckIfThreeOfSameSymbolInDiagonal() {
        cells = new ArrayList<String>(Arrays.asList("O","2","X","4","O","O","7","8","O"));
        board = new Board(out, cells);
        assertThat(board.hasThreeInADiagonal(), is(true));
    }

    @Test
    public void shouldCheckIfThereIsAWinner() {
        cells = new ArrayList<String>(Arrays.asList("O","2","X","4","O","O","7","8","O"));
        board = new Board(out, cells);

        assertThat(board.hasWinner(), is(true));
    }
}