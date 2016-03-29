package UniqueBinarySearchTrees;

/**
 * Created by SimingYe on 2/12/16.
 */
public class UniqueBinarySearchTrees2
{
    public int numTrees(int n)
    {
        if (n < 0)
            return 0;

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            for (int j = 0; j <= i - 1; j++)
            {
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
