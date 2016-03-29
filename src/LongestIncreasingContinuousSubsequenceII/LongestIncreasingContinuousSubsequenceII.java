package LongestIncreasingContinuousSubsequenceII;

/**
 * Created by SimingYe on 3/16/16.
 */
public class LongestIncreasingContinuousSubsequenceII
{
    public int longestIncreasingContinuousSubsequenceII(int[][] A)
    {
        if (A == null || A.length == 0)
            return 0;

        int m = A.length;
        int n = A[0].length;
        int result = 0;

        int[][] dp = new int[m][n];
        int[][] flag = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                result = Math.max(result, search(i, j, A, flag, dp));
            }
        }

        return result;
    }

    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};

    public int search(int x, int y, int[][] A, int[][] flag, int[][] dp)
    {
        if (flag[x][y] != 0)
        {
            return dp[x][y];
        }

        int result = 1;

        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < A.length && ny >= 0 && ny < A[0].length)
            {
                if (A[nx][ny] < A[x][y])
                {
                    result = Math.max(result, search(nx, ny, A, flag, dp) + 1);
                }
            }
        }

        flag[x][y] = 1;
        dp[x][y] = result;
        return result;
    }
}
