import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class GameTest {

    @Test
    public void shouldPrintBoardOnStart() {
        PrintStream out = mock(PrintStream.class);
        Board board = mock(Board.class);
        Game game = new Game(board, out);

        game.play();

        verify(out).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }
}
