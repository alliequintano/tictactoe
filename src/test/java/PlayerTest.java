import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

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
        player = new Player(out, in, "X", board);
    }

    @Test
    public void shouldPromptUserToMakeMove() throws IOException {
        player.makeMove();

        verify(out).println("Select position on board: ");
    }

    @Test
    public void shouldTakePlayerInputToMakeMove() throws IOException {
        when(in.readLine()).thenReturn("1");

        player.makeMove();

        verify(board).addPlayerSymbolToBoard("1", "X");
    }

    @Test
    public void shouldPromptPlayerToMakeMoveAgainIfMoveIsTaken() throws IOException {
        when(board.cells()).thenReturn(new ArrayList<String>(Arrays.asList("1","X","3","4","5","6","7","8","9")));
        when(in.readLine()).thenReturn("2").thenReturn("3");

        player.makeMove();

        verify(out).println("Already taken.");
    }

}