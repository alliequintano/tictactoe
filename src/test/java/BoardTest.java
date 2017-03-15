import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class BoardTest {
    PrintStream out;
    String cells;
    Board board;

    @Before
    public void setup() {
        out = mock(PrintStream.class);
        cells = "1|2|3\n-----\n4|5|6\n-----\n7|8|9";
        board = new Board(out, cells);
    }

    @Test
    public void shouldPrintBoard() {
        board.printBoard();

        verify(out).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }

    @Test
    public void shouldAddMoveToBoardByMarkingMoveWithSymbol() {
        cells = board.addPlayerSymbolToBoard("3", "X");

        assertThat(cells, is("1|2|X\n-----\n4|5|6\n-----\n7|8|9"));
    }

    @Test
    public void shouldMakeMoveWithSecondPlayerSymbol() {
        cells = board.addPlayerSymbolToBoard("5", "O");

        assertThat(cells, is("1|2|3\n-----\n4|O|6\n-----\n7|8|9"));
    }

    @Test
    public void shouldNotAddMoveWhenAlreadyTaken() {
        board = new Board(out, "1|X|3\n-----\n4|5|6\n-----\n7|8|9");
        cells = board.addPlayerSymbolToBoard("2", "O");

        assertThat(cells, is("1|X|3\n-----\n4|5|6\n-----\n7|8|9"));
    }
}