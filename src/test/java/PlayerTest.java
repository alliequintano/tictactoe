import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class PlayerTest {

    @Test
    public void shouldPromptUserToMakeMove() throws IOException {
        Board board = mock(Board.class);
        PrintStream out = mock(PrintStream.class);
        Player player = new Player(board, out);
        player.makeMove();

        verify(out).println("Select position on board: ");
    }

}