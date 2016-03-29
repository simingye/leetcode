package Amazon;

/**
 * Created by SimingYe on 2/19/16.
 */
public class MaxMinPath
{
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    public int maxminpath(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        helper(matrix, 0, 0, min);

        return max;
    }

    public void helper(int[][] matrix, int x, int y, int min)
    {
        if (x > matrix.length - 1 || y > matrix[0].length - 1)
        {
            return;
        }

        if (x == matrix.length-1 && y == matrix[0].length-1)
        {
            min = Math.min(min, matrix[x][y]);
            max = Math.max(max, min);
            return;
        }

        min = Math.min(min, matrix[x][y]);

        helper(matrix, x+1, y, min);
        helper(matrix, x, y+1, min);
    }

    public static void main(String[] args) {
        int[][] matrix = {{8,4,7},{6,5,9}};
        MaxMinPath test = new MaxMinPath();
        System.out.println(test.maxminpath(matrix));
    }
}
