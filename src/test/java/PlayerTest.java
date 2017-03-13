import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class PlayerTest {
    Board board;
    Player player;
    PrintStream out;
    BufferedReader in;

    @Before
    public void setUp() {
        board = mock(Board.class);
        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        player = new Player(out, in);
    }

    @Test
    public void shouldPromptUserToMakeMove() throws IOException {
        player.makeMove(board);

        verify(out).println("Select position on board: ");
    }

    @Test
    public void shouldTakeUserInputToMakeMove() throws IOException {
        when(in.readLine()).thenReturn("1");
        player.makeMove(board);

        verify(board).addPlayerSymbolToBoard("1");
    }
}