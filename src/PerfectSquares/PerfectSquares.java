package PerfectSquares;

import java.util.Arrays;

/**
 * Created by SimingYe on 1/21/16.
 */
public class PerfectSquares
{
    public int numSquares(int n)
    {
        int dp[] = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++)
        {
            dp[i * i] = 1;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; i + j * j <= n; j++)
            {
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares test = new PerfectSquares();
        System.out.println(test.numSquares(4));
    }
}
