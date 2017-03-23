import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
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
        board = new Board(out);
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

        board.addPlayerSymbolToBoard("2", "X");
        board.addPlayerSymbolToBoard("2", "O");

        assertThat(board.cells().get(cellIndex), is("X"));
    }

    @Test
    public void shouldCheckIfAllCellsAreTaken() {
        board = new Board(out);
        board.addPlayerSymbolToBoard("1", "Z");
        board.addPlayerSymbolToBoard("2", "P");
        board.addPlayerSymbolToBoard("3", "P");
        board.addPlayerSymbolToBoard("4", "P");
        board.addPlayerSymbolToBoard("5", "P");
        board.addPlayerSymbolToBoard("6", "P");
        board.addPlayerSymbolToBoard("7", "P");
        board.addPlayerSymbolToBoard("8", "P");
        board.addPlayerSymbolToBoard("9", "P");

        assertThat(board.isFull(), is(true));
    }
}