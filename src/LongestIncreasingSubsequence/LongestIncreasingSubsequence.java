package LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * Created by SimingYe on 1/22/16.
 */
public class LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int max = 1;

        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[j] < nums[i])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
