package GameOfLife;

/**
 * Created by SimingYe on 1/21/16.
 */
public class GameOfLife
{
    public void gameOfLife(int[][] board)
    {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                int x = getLiveNum(board, i, j);
                if (board[i][j] == 0)
                {
                    if (x == 3)
                    {
                        board[i][j] += 10;
                    }
                }
                else
                {
                    if (x == 2 || x == 3)
                    {
                        board[i][j] += 10;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                board[i][j] /= 10;
            }
        }
    }

    public int getLiveNum(int[][] board, int x, int y)
    {
        int c = 0;
        for (int i = x - 1; i <= x + 1; i++)
        {
            for (int j = y - 1; j <= y + 1; j++)
            {
                if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || (i == x && j == y))
                    continue;

                if (board[i][j] % 10 == 1)
                    c++;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        GameOfLife test = new GameOfLife();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
        test.gameOfLife(board);
    }
}
