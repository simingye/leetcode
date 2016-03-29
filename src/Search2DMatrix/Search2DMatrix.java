package Search2DMatrix;

/**
 * Created by Siming on 9/25/15.
 */
public class Search2DMatrix
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix == null || matrix.length == 0)
            return false;

        int numOfRows = matrix.length;
        int numOfColumn = matrix[0].length;
        int top = 0;
        int bottom = numOfRows - 1;
        int mid;

        while (top + 1 != bottom && top < bottom)
        {
            mid = (top + bottom) / 2;
            if (target < matrix[mid][0])
            {
                bottom = mid;
            }
            else if (target > matrix[mid][0])
            {
                top = mid;
            }
            else
            {
                return true;
            }
        }

        if (target < matrix[bottom][0])
        {
            for (int i = 0; i < numOfColumn; i++)
            {
                if (target == matrix[top][i])
                    return true;
            }
        }
        else if (target > matrix[bottom][0])
        {
            for (int i = 0; i < numOfColumn; i++)
            {
                if (target == matrix[bottom][i])
                    return true;
            }
        }
        else
        {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix test = new Search2DMatrix();
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] matrix = {{1}};
        System.out.println(test.searchMatrix(matrix, 1));
    }
}
