package LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * Created by SimingYe on 3/16/16.
 */
public class LongestIncreasingSubsequence2
{
    public int longestIncreasingSubsequence(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int max = 1;

        Arrays.fill(dp, 1);

        for (int i = 0; i < dp.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[j] <= nums[i])
                {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
