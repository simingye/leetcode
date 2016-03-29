package MinimumSizeSubarraySum;

/**
 * Created by Siming on 11/6/15.
 */
public class MinimumSizeSubarraySum
{
    public int minSubArrayLen(int s, int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int left = 0;
        int right = 0;
        int sum = 0;
        int length = nums.length;
        int result = Integer.MAX_VALUE;

        while (right < length)
        {
            while (sum < s && right < length)
            {
                sum += nums[right];
                right++;
            }

            while (sum >= s && left < right)
            {
                result = Math.min(result, right - left);
                sum -= nums[left];
                left++;
            }
        }

        if (result == Integer.MAX_VALUE)
        {
            return 0;
        }
        else
        {
            return result;
        }
    }
}
