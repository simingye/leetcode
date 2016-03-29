package CoinsInaLineII;

/**
 * Created by SimingYe on 3/16/16.
 */
public class CoinsInaLineII
{
    public boolean firstWillWin(int[] values)
    {
        if (values == null || values.length <= 2)
            return true;

        int[] dp = new int[values.length+1];
        int n = values.length;

        dp[0] = 0;
        dp[1] = values[n-1];
        dp[2] = values[n-1] + values[n-2];
        dp[3] = values[n-2] + values[n-3];

        for (int i = 4; i < dp.length; i++)
        {
            dp[i] = Math.max(Math.min(dp[i-2], dp[i-3]) + values[n-i], Math.min(dp[i-3], dp[i-4]) + values[n-i] + values[n-i+1]);
        }

        int sum = 0;
        for (int i = 0; i < values.length; i++)
        {
            sum += values[i];
        }

        return dp[values.length] * 2 > sum;
    }

    public static void main(String[] args) {
        CoinsInaLineII test = new CoinsInaLineII();
        int[] nums = {1,2,2};
        System.out.println(test.firstWillWin(nums));
    }
}
