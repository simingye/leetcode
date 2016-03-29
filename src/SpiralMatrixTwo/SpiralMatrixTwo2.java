package SpiralMatrixTwo;

/**
 * Created by SimingYe on 2/4/16.
 */
public class SpiralMatrixTwo2
{
    public int[][] generateMatrix(int n)
    {
        if (n <= 0)
            return null;

        int[][] matrix = new int[n][n];

        int i = 1;
        int x = 0;
        int y = 0;
        matrix[0][0] = 1;
        i++;

        while (i < n * n)
        {
            while (y < n - 1 && matrix[x][y + 1] == 0)
            {
                y++;
                matrix[x][y] = i;
                i++;
            }

            while (x < n - 1 && matrix[x + 1][y] == 0)
            {
                x++;
                matrix[x][y] = i;
                i++;
            }

            while (y > 0 && matrix[x][y - 1] == 0)
            {
                y--;
                matrix[x][y] = i;
                i++;
            }

            while (x > 0 && matrix[x - 1][y] == 0)
            {
                x--;
                matrix[x][y] = i;
                i++;
            }
        }

        return matrix;
    }
}
