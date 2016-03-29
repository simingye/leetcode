package SpiralMatrixTwo;

/**
 * Created by Siming on 9/11/15.
 */
public class SpiralMatrixTwo
{
    public int[][] generateMatrix(int n)
    {
        int[][] matrix = new int[n][n];

        int m = n;
        int x = 0;
        int y = 0;
        int num = 1;

        while (m > 0)
        {
            if (m == 1)
            {
                matrix[x][y] = num++;
                break;
            }

            //left to right
            for (int i = 0; i < m-1; i++)
            {
                matrix[x][y++] = num++;
            }

            //top to bottom
            for (int i = 0; i < m-1; i++)
            {
                matrix[x++][y] = num++;
            }

            //right to left
            for (int i = 0; i < m-1; i++)
            {
                matrix[x][y--] = num++;
            }

            //bottom to top
            for (int i = 0; i < m-1; i++)
            {
                matrix[x--][y] = num++;
            }

            m -= 2;
            x++;
            y++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixTwo test = new SpiralMatrixTwo();
        int[][] matrix = test.generateMatrix(4);

        for (int i = 0; i < matrix.length; i++)
        {
            for (int element : matrix[i])
            {
                System.out.print(element + ",");
            }
            System.out.println("");
        }
    }
}
