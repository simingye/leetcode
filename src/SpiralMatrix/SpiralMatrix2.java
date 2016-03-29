package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 2/3/16.
 */
public class SpiralMatrix2
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = 0;

        while (m > 0 && n > 0)
        {
            if (m == 1)
            {
                for (int i = 0; i < n; i++)
                {
                    result.add(matrix[x][y]);
                    y++;
                }
                break;
            }
            else if (n == 1)
            {
                for (int i = 0; i < m; i++)
                {
                    result.add(matrix[x][y]);
                    x++;
                }
                break;
            }

            //top
            for (int i = 0; i < n - 1; i++)
            {
                result.add(matrix[x][y]);
                y++;
            }

            //right
            for (int i = 0; i < m - 1; i++)
            {
                result.add(matrix[x][y]);
                x++;
            }

            //bottom
            for (int i = 0; i < n - 1; i++)
            {
                result.add(matrix[x][y]);
                y--;
            }

            //left
            for (int i = 0; i < m - 1; i++)
            {
                result.add(matrix[x][y]);
                x--;
            }

            x++;
            y++;
            m -= 2;
            n -= 2;
        }

        return result;
    }
}
