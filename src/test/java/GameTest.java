import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class GameTest {
    Game game;
    Board board;
    Player player1;
    Player player2;

    @Before
    public void setUp() {
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(board, player1, player2);
    }

    @Test
    public void shouldPrintBoardOnStart() throws IOException {
        game.play();
        verify(board).printBoard();
    }

    @Test
    public void shouldHavePlayer1MakeMove() throws IOException {
        game.play();
        verify(player1).makeMove();
    }

    @Test
    public void shouldHavePlayer2MakeMoveAfterPlayer1() throws IOException {
        game.play();

        verify(player2).makeMove();
    }
}
