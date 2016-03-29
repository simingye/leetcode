package RotateImage;

/**
 * Created by Siming on 9/9/15.
 */
public class RotateImage
{
    public void rotate(int[][] matrix)
    {
        int m = matrix.length;
        int[][] result = new int[m][m];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < m; j++)
            {
                result[j][m-1-i] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < m; j++)
            {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
