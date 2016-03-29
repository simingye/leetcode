package SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Siming on 10/22/15.
 */
public class SurroundedRegions
{
    private Queue<Integer> queue = new LinkedList<>();

    public void solve(char[][] board)
    {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++)
        {
            if (board[i][0] == 'O')
            {
                bfs(board, i, 0);
            }

            if (board[i][n - 1] == 'O')
            {
                bfs(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++)
        {
            if (board[0][j] == 'O')
            {
                bfs(board, 0, j);
            }

            if (board[m - 1][j] == 'O')
            {
                bfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#')
                {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char[][] board, int x, int y)
    {
        int n = board[0].length;

        fillCell(board, x, y);

        while (!queue.isEmpty())
        {
            int cur = queue.poll();
            int i = cur / n;
            int j = cur % n;

            fillCell(board, i - 1, j);
            fillCell(board, i + 1, j);
            fillCell(board, i, j - 1);
            fillCell(board, i, j + 1);
        }
    }

    public void fillCell(char[][] board, int x, int y)
    {
        int m = board.length;
        int n = board[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O')
            return;

        queue.offer(x * n + y);
        board[x][y] = '#';
    }
}
