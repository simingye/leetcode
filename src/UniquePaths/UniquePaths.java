package UniquePaths;

/**
 * Created by Siming on 9/16/15.
 */
public class UniquePaths
{
    public int uniquePaths(int m, int n)
    {
        if (m == 1 || n == 1)
        {
            return 1;
        }

        int[][] matrix = new int[m][n];

        matrix[m-1][n-1] = 0;

        for (int i = 0; i < n-1; i++)
        {
            matrix[m-1][i] = 1;
        }

        for (int i = 0; i < m-1; i++)
        {
            matrix[i][n-1] = 1;
        }

        for (int i = m-2; i >=0; i--)
        {
            for (int j = n-2; j >= 0; j--)
            {
                matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
            }
        }

        return matrix[0][0];
    }

}
