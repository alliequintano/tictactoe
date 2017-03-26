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

    @Test
    public void shouldCheckIfThreeOfSameSymbolsInARow() {
        board.addPlayerSymbolToBoard("1", "o");
        board.addPlayerSymbolToBoard("2", "o");
        board.addPlayerSymbolToBoard("3", "o");

        assertThat(board.hasThreeInARow(), is(true));
    }

    @Test
    public void shouldCheckIfThreeOfSameSymbolInColumn() {
        board.addPlayerSymbolToBoard("2", "o");
        board.addPlayerSymbolToBoard("5", "o");
        board.addPlayerSymbolToBoard("8", "o");

        assertThat(board.hasThreeInAColumn(), is(true));
    }

    @Test
    public void shouldCheckIfThreeOfSameSymbolInDiagonal() {
        board.addPlayerSymbolToBoard("3", "j");
        board.addPlayerSymbolToBoard("5", "j");
        board.addPlayerSymbolToBoard("7", "j");

        assertThat(board.hasThreeInADiagonal(), is(true));
    }
}