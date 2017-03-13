import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        game = new Game(board, player, player);
    }

    @Test
    public void shouldPrintBoardOnStart() throws IOException {
        game.play();
        verify(board).printBoard();
    }

    @Test
    public void shouldHavePlayer1MakeMove() throws IOException {
        game.play();
        verify(player).makeMove(board);
    }

    @Test
    public void shouldHavePlayer2MakeMoveAfterPlayer1() throws IOException {
        Player player2 = mock(Player.class);
        Board board2 = mock(Board.class);
        Game game = new Game(board, player, player2);
        when(player.makeMove(board)).thenReturn(board2);

        game.play();

        verify(player2).makeMove(board2);
    }
}
