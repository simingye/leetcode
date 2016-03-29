package MaximalSquare;

/**
 * Created by SimingYe on 3/16/16.
 */
public class MaximalSquare2
{
    public int maxSquare(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            result[i][0] = matrix[i][0];
        }

        for (int i = 0; i < n; i++)
        {
            result[0][i] = matrix[0][i];
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (matrix[i][j] == 1)
                {
                    result[i][j] = Math.min(Math.min(result[i-1][j], result[i-1][j-1]), result[i][j-1]) + 1;
                }
                else
                {
                    result[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                ans = Math.max(ans, result[i][j]);
            }
        }

        return ans * ans;
    }
}
