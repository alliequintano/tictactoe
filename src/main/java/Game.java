import java.io.IOException;

/**
 * Created by alexandraquintano on 3/3/17.
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() throws IOException {
        board.printBoard();
        board = player1.makeMove(board);
        board = player2.makeMove(board);
    }
}
