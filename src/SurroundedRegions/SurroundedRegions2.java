package SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SimingYe on 2/29/16.
 */
public class SurroundedRegions2
{
    Queue<Integer> queue = new LinkedList<>();

    public void solve(char[][] board)
    {
        if (board == null || board.length == 0)
            return;

        int rowLen = board.length;
        int colLen = board[0].length;

        for (int i = 0; i < rowLen; i++)
        {
            if (board[i][0] == 'O')
            {
                bfs(board, i, 0);
            }

            if (board[i][colLen-1] == 'O')
            {
                bfs(board, i, colLen-1);
            }
        }

        for (int i = 0; i < colLen; i++)
        {
            if (board[0][i] == 'O')
            {
                bfs(board, 0, i);
            }

            if (board[rowLen-1][i] == 'O')
            {
                bfs(board, rowLen-1, i);
            }
        }

        for (int i = 0; i < rowLen; i++)
        {
            for (int j = 0; j < colLen; j++)
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

    public void fillCell(char[][] board, int x, int y)
    {
        int m = board.length;
        int n = board[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O')
            return;

        queue.add(x * n + y);
        board[x][y] = '#';
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

            fillCell(board, i-1, j);
            fillCell(board, i+1, j);
            fillCell(board, i, j+1);
            fillCell(board, i, j-1);
        }
    }
}
