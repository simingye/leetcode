package MaximalSquare;

/**
 * Created by SimingYe on 1/14/16.
 */
public class MaximalSquare
{
    public int maximalSquare(char[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] t = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            t[i][0] = Character.getNumericValue(matrix[i][0]);
        }

        for (int i = 0; i < n; i++)
        {
            t[0][i] = Character.getNumericValue(matrix[0][i]);
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (matrix[i][j] == '1')
                {
                    t[i][j] = Math.min(Math.min(t[i - 1][j], t[i][j - 1]), t[i - 1][j - 1]) + 1;
                }
                else
                {
                    t[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                max = Math.max(max, t[i][j]);
            }
        }

        return max * max;
    }
}
