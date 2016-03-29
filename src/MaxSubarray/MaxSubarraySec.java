package MaxSubarray;

/**
 * Created by Siming on 10/28/15.
 */
public class MaxSubarraySec
{
    public int maxSubarray(int[] nums)
    {
        //opt[i]表示最大连续的数的和
        int[] opt = new int[nums.length];
        int max = nums[0];
        opt[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            opt[i] = Math.max(nums[i], opt[i - 1] + nums[i]);
            max = Math.max(max, opt[i]);
        }

        return max;
    }
}
