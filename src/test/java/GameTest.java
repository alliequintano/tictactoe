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
        Game game = new Game(board);

        game.play();

        verify(board).printBoard();
    }
}
