package UniquePathsTwo;

/**
 * Created by Siming on 9/16/15.
 */
public class UniquePathsTwo
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] matrix = new int[rows][columns];

        if (obstacleGrid[rows-1][columns-1] != 1)
        {
            matrix[rows-1][columns-1] = 0;
        }
        else
        {
            return 0;
        }

        if (obstacleGrid[0][0] == 1)
            return 0;

        if (rows == 1)
        {
            int sum = 0;
            for (int i = 0; i < columns; i++)
            {
                sum += obstacleGrid[0][i];
            }

            if (sum == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        if (columns == 1)
        {
            int sum = 0;
            for (int i = 0; i < rows; i++)
            {
                sum += obstacleGrid[i][0];
            }

            if (sum == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        matrix[rows-1][columns-1] = 0;

        boolean flag = false;
        for (int i = rows-2; i >= 0; i--)
        {
            if (obstacleGrid[i][columns-1] == 1)
            {
                flag = true;
            }

            if (flag == false)
            {
                matrix[i][columns-1] = 1;
            }
            else
            {
                matrix[i][columns-1] = 0;
            }
        }

        flag = false;
        for (int i = columns-2; i >= 0; i--)
        {
            if (obstacleGrid[rows-1][i] == 1)
            {
                flag = true;
            }

            if (flag == false)
            {
                matrix[rows-1][i] = 1;
            }
            else
            {
                matrix[rows-1][i] = 0;
            }
        }

        flag = true;
        for (int i = rows-2; i >= 0; i--)
        {
            for (int j = columns-2; j >= 0; j--)
            {
                if (obstacleGrid[i][j] == 1)
                {
                    matrix[i][j] = 0;
                }
                else
                {
                    matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
                }
            }
        }

        return matrix[0][0];
    }

    public static void main(String[] args) {
        UniquePathsTwo test = new UniquePathsTwo();
        int[][] map = {{0,0},{1,1},{0,0}};
        System.out.println(test.uniquePathsWithObstacles(map));
    }
}
