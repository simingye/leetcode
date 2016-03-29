package Amazon;

/**
 * Created by SimingYe on 2/17/16.
 */
public class SearchA2DMatrixTwo
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = matrix[0].length - 1;

        if (target < matrix[0][0] || target > matrix[m-1][n-1])
            return false;

        while (x < m && y >= 0)
        {
            int number = matrix[x][y];

            if (target == number)
            {
                return true;
            }
            else if (target < number)
            {
                y--;
            }
            else
            {
                x++;
            }
        }

        return false;
    }
}
