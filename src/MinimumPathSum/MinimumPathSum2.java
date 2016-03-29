package MinimumPathSum;

/**
 * Created by SimingYe on 2/8/16.
 */
public class MinimumPathSum2
{
    public int minPathSum(int[][] grid)
    {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++)
        {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++)
        {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (dp[i-1][j] > dp[i][j-1])
                {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
