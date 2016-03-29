package SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SimingYe on 3/24/16.
 */
public class SurroundedRegions3
{
    Queue<Integer> queue = new LinkedList<>();

    public void solve(char[][] board)
    {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        boolean[][] flag = new boolean[m][n];

        for (int i = 0; i < m; i++)
        {
            if (board[i][0] == 'O')
            {
                dfs(board, i, 0, flag);
            }

            if (board[i][n - 1] == 'O')
            {
                dfs(board, i, n - 1, flag);
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (board[0][i] == 'O')
            {
                dfs(board, 0, i, flag);
            }

            if (board[m - 1][i] == 'O')
            {
                dfs(board, m - 1, i, flag);
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == '#')
                {
                    board[i][j] = 'O';
                }
                else
                {
                    board[i][j] = 'X';
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

    public void dfs(char[][] board, int x, int y, boolean[][] flag)
    {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;

        if (flag[x][y])
            return;

        int n = board[0].length;

        fillCell(board, x, y);

        while (!queue.isEmpty())
        {
            int cur = queue.poll();
            int i = cur / n;
            int j = cur % n;

            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
                return;

            fillCell(board, i-1, j);
            fillCell(board, i+1, j);
            fillCell(board, i, j+1);
            fillCell(board, i, j-1);
        }
    }

    public static void main(String[] args) {
        SurroundedRegions3 test = new SurroundedRegions3();
        char[][] board = {{'O'}};
        test.solve(board);
    }
}
