package StoneGame;

/**
 * Created by SimingYe on 3/22/16.
 */
public class StoneGame
{
    public int stoneGame(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;

        int[][] dp = new int[A.length][A.length];
        int[][] flag = new int[A.length][A.length];
        int[][] sums = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++)
        {
            sums[i][i] = A[i];
            for (int j = i+1; j < A.length; j++)
            {
                sums[i][j] = sums[i][j-1] + A[j];
            }
        }

        for (int i = 0; i < A.length; i++)
        {
            dp[i][i] = 0;
        }

        return search(0, A.length-1, dp, flag, sums);
    }

    public int search(int left, int right, int[][] dp, int[][] flag, int[][] sum)
    {
        if (flag[left][right] == 1)
            return dp[left][right];

        if (left == right)
        {
            flag[left][right] = 0;
            return dp[left][right];
        }

        dp[left][right] = Integer.MAX_VALUE;
        for (int k = left; k < right; k++)
        {
            dp[left][right] = Math.min(dp[left][right], search(left, k, dp, flag, sum) + search(k+1, right, dp, flag, sum) + sum[left][right]);
        }

        flag[left][right] = 1;

        return dp[left][right];
    }
}
