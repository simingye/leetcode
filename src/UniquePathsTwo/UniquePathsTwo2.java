package UniquePathsTwo;

import UniquePaths.UniquePaths2;

/**
 * Created by SimingYe on 2/5/16.
 */
public class UniquePathsTwo2
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;

        int[][] grid = new int[m][n];
        grid[0][0] = 1;

        //last row
        for (int i = 0; i < n; i++)
        {
            if (grid[m-1][i] != -1)
            {
                grid[m-1][i] = 1;
            }
        }

        //last column
        for (int i = 0; i < m; i++)
        {
            if (grid[i][n-1] != -1)
            {
                grid[i][n-1] = 1;
            }
        }

        for (int i = m - 2; i >= 0; i--)
        {
            for (int j = n - 2; j >= 0; j--)
            {
                if (grid[i][j] == -1)
                    continue;

                if (grid[i+1][j] == -1)
                {
                    grid[i][j] = grid[i][j+1];
                }
                else if (grid[i][j+1] == -1)
                {
                    grid[i][j] = grid[i+1][j];
                }
                else if(grid[i][j+1] == -1 && grid[i+1][j] == -1)
                {
                    grid[i][j] = 0;
                }
                else
                {
                    grid[i][j] = grid[i+1][j] + grid[i][j+1];
                }
            }
        }

        if (grid[0][0] == -1)
            return 0;

        return grid[0][0];
    }

    public static void main(String[] args) {
        UniquePathsTwo2 test = new UniquePathsTwo2();
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(test.uniquePathsWithObstacles(grid));
    }
}
