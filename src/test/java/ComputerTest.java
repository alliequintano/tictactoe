import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static sun.audio.AudioPlayer.player;

public class ComputerTest {

    private PrintStream out;
    private BufferedReader in;
    private Board board;
    Player player;

    @Before
    public void setUp() {
        board = mock(Board.class);
        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        player = new Computer(out, in, "C", board);
    }

    @Test
    public void shouldMakeMove() {
        player.makeMove();
        verify(board).addPlayerSymbolToBoard("1","C");
    }

    @Test
    public void shouldPickAnotherCellIfCellIsTaken() {
        when(board.cellIsTaken("1")).thenReturn(true);
        when(board.cellIsTaken("2")).thenReturn(false);
        player.makeMove();
        verify(board).addPlayerSymbolToBoard("2", "C");
    }

}
