package NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Siming on 11/1/15.
 */
public class NumberOfIslandsSec
{
    public int numIslands(char[][] grid)
    {
        if (grid == null || grid.length == 0)
            return 0;

        int count = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1')
                {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, int x, int y)
    {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.add(x);
        queue2.add(y);

        grid[x][y] = '#';

        while (!queue1.isEmpty() && !queue2.isEmpty())
        {
            int m = queue1.poll();
            int n = queue2.poll();

            if (m < grid.length - 1 && grid[m+1][n] == '1')
            {
                grid[m+1][n] = '#';
                queue1.add(m+1);
                queue2.add(n);
            }

            if (m >= 1 && grid[m-1][n] == '1')
            {
                grid[m-1][n] = '#';
                queue1.add(m-1);
                queue2.add(n);
            }

            if (n < grid[0].length - 1 && grid[m][n+1] == '1')
            {
                grid[m][n+1] = '#';
                queue1.add(m);
                queue2.add(n+1);
            }

            if (n >= 1 && grid[m][n-1] == '1')
            {
                grid[m][n-1] = '#';
                queue1.add(m);
                queue2.add(n-1);
            }
        }
    }
}

