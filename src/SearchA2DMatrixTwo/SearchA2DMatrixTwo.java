package SearchA2DMatrixTwo;

/**
 * Created by SimingYe on 1/19/16.
 */
public class SearchA2DMatrixTwo
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        return search(0, m - 1, 0, n - 1, matrix, target);
    }

    public boolean search(int rowStart, int rowEnd, int colStart, int colEnd, int[][] matrix, int target)
    {
        if (rowEnd < rowStart || colEnd < colStart)
            return false;

        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (colStart + colEnd) / 2;

        if (target == matrix[rowMid][colMid])
        {
            return true;
        }
        else if (target > matrix[rowMid][colMid])
        {
            return search(rowMid + 1, rowEnd, colMid + 1, colEnd, matrix, target)
                    || search(rowMid + 1, rowEnd, colStart, colMid, matrix, target)
                    || search(rowStart, rowMid, colMid + 1, colEnd, matrix, target);
        }
        else
        {
            return search(rowStart, rowMid - 1, colStart, colMid - 1, matrix, target)
                    || search(rowMid, rowEnd, colStart, colMid - 1, matrix, target)
                    || search(rowStart, rowMid - 1, colMid, colEnd, matrix, target);
        }
    }
}
