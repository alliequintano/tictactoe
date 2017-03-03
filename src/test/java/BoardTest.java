import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class BoardTest {

    @Test
    public void shouldPrintBoard() {
        PrintStream out = mock(PrintStream.class);
        Board board = new Board(out);

        board.printBoard();

        verify(out).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }

}