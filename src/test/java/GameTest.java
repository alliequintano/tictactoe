import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class GameTest {
    Game game;
    Board board;
    Human player1;
    Human player2;
    PrintStream out;

    @Before
    public void setUp() {
        board = mock(Board.class);
        player1 = mock(Human.class);
        player2 = mock(Human.class);
        out = mock(PrintStream.class);
        game = new Game(board, player1, player2, out);
    }

    @Test
    public void shouldPrintBoardOnStart() throws IOException {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        game.play();
        verify(board, atLeast(1)).printBoard();
    }

    @Test
    public void shouldHavePlayer1MakeMove() throws IOException {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        game.play();
        verify(player1).makeMove();
    }

    @Test
    public void shouldHavePlayer2MakeMoveAfterPlayer1() throws IOException {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);
        game.play();
        verify(player2).makeMove();
    }

    @Test
    public void shouldPlayGameUntilBoardIsFull() throws IOException {
        when(board.isFull()).thenReturn(true);
        game.play();
        verify(out).println("Game is a draw.");
    }

    @Test
    public void shouldPlayGameUntilBoardHasWinner() {
        when(board.hasWinner()).thenReturn(true);
        when(board.isFull()).thenReturn(false);
        game.play();
        verify(player1).printPlayerWonMessage();
    }


}
