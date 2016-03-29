package MaxSubarray;

/**
 * Created by SimingYe on 2/2/16.
 */
public class MaxSubarray2
{
    public int maxSubArray(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int result = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        result = dp[0];

        for (int i = 1; i < nums.length; i++)
        {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
