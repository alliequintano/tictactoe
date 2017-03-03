import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class GameTest {
    Game game;
    Board board;
    Player player;

    @Before
    public void setUp() {
        board = mock(Board.class);
        player = mock(Player.class);
        game = new Game(board, player);
    }

    @Test
    public void shouldPrintBoardOnStart() throws IOException {
        game.play();
        verify(board).printBoard();
    }

    @Test
    public void shouldPromptPlayerForMove() throws IOException {
        game.play();
        verify(player).makeMove();
    }
}
