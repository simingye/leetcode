package UniquePaths;

/**
 * Created by SimingYe on 2/5/16.
 */
public class UniquePaths2
{
    public int uniquePaths(int m, int n)
    {
        if (m == 0 || n == 0)
        {
            return 0;
        }

        if (m == 1 || n == 1)
            return 1;

        int[][] grid = new int[m][n];

        //last row
        for (int i = 0; i < n; i++)
        {
            grid[m - 1][i] = 1;
        }

        //last column
        for (int i = 0; i < m; i++)
        {
            grid[i][n - 1] = 1;
        }

//        grid[m - 1][n - 1] = 0;

        for (int i = m - 2; i >= 0; i--)
        {
            for (int j = n - 2; j >= 0; j--)
            {
                grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
            }
        }

        return grid[0][0];
    }

    public static void main(String[] args) {
        UniquePaths2 test = new UniquePaths2();
        System.out.println(test.uniquePaths(3, 7));
    }
}
