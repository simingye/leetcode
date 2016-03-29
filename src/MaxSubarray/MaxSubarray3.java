package MaxSubarray;

/**
 * Created by SimingYe on 3/3/16.
 */
public class MaxSubarray3
{
    public int maxSubArray(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        max = dp[0];

        for (int i = 1; i < nums.length; i++)
        {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSubarray3 test = new MaxSubarray3();
        int[] nums = {1};
        System.out.println(test.maxSubArray(nums));
    }
}
