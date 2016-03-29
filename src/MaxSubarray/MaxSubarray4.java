package MaxSubarray;

/**
 * Created by SimingYe on 3/15/16.
 */
public class MaxSubarray4
{
    public int maxSubArray(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++)
        {
            if (dp[i-1] + nums[i] > nums[i])
            {
                dp[i] = dp[i-1] + nums[i];
                result = Math.max(result, dp[i-1] + nums[i]);
            }
            else
            {
                dp[i] = nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSubarray4 test = new MaxSubarray4();
        int[] nums = {-2,2,-3,4,-1,2,1,-5,3};
        System.out.println(test.maxSubArray(nums));
    }
}
