package SetMatrixZeroes;

/**
 * Created by Siming on 9/23/15.
 */
public class SetMatrixZeroes
{
    public void setZeroes(int[][] matrix)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean firstRow = false;
        boolean firstColumn = false;

        if (matrix == null || rows == 0 || columns == 0)
            return;

        for (int i = 0; i < rows; i++)
        {
            if (matrix[i][0] == 0)
            {
                firstColumn = true;
                break;
            }
        }

        for (int i = 0; i < columns; i++)
        {
            if (matrix[0][i] == 0)
            {
                firstRow = true;
                break;
            }
        }

        if (rows > 1 && columns > 1)
        {
            for (int i = 1; i < rows; i++)
            {
                for (int j = 1; j < columns; j++)
                {
                    if (matrix[i][j] == 0)
                    {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = 1; i < rows; i++)
            {
                if (matrix[i][0] == 0)
                {
                    for (int j = 0; j < columns; j++)
                    {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int i = 1; i < columns; i++)
            {
                if (matrix[0][i] == 0)
                {
                    for (int j = 0; j < rows; j++)
                    {
                        matrix[j][i] = 0;
                    }
                }
            }
        }

        if (firstColumn == true)
        {
            for (int i = 0; i < rows; i++)
            {
                matrix[i][0] = 0;
            }
        }

        if (firstRow == true)
        {
            for (int i = 0; i < columns; i++)
            {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes test = new SetMatrixZeroes();
        int[][] matrix = {{0}};
        test.setZeroes(matrix);
    }
}
