import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class HumanTest {
    Board board;
    Player player;
    PrintStream out;
    BufferedReader in;

    @Before
    public void setUp() {
        board = mock(Board.class);
        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        player = new Human(out, in, "X", board, "Player1");
    }

    @Test
    public void shouldPromptUserToMakeMove() throws IOException {
        when(in.readLine()).thenReturn("1");

        player.makeMove();

        verify(out).println("Player1 Select position on board: ");
    }

    @Test
    public void shouldTakePlayerInputToMakeMove() throws IOException {
        when(in.readLine()).thenReturn("1");

        player.makeMove();

        verify(board).addPlayerSymbolToBoard("1", "X");
    }

    @Test
    public void shouldPromptPlayerToMakeMoveAgainIfMoveIsTaken() throws IOException {
        when(board.cellIsTaken("2")).thenReturn(true);
        when(board.cellIsTaken("3")).thenReturn(false);
        when(in.readLine()).thenReturn("2").thenReturn("3");

        player.makeMove();

        verify(out).println("Already taken. Enter a different move: ");
    }

    @Test
    public void shouldPrintPlayerWonMessage() {
        player.printPlayerWonMessage();

        verify(out).println("Player1 Wins!");
    }

}