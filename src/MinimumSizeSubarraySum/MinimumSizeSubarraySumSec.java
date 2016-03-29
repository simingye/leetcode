package MinimumSizeSubarraySum;

/**
 * Created by Siming on 11/9/15.
 */
public class MinimumSizeSubarraySumSec
{
    public int minSubArrayLen(int s, int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while (right < nums.length)
        {
            while (sum < s && right < nums.length)
            {
                sum += nums[right];
                right++;
            }

            while (sum >= s && left < right)
            {
                sum -= nums[left];
                left++;
                result = Math.min(result, right - left + 1);
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

    public static void main(String[] args) {
        MinimumSizeSubarraySumSec test = new MinimumSizeSubarraySumSec();
        int[] nums = {1,1};
        System.out.println(test.minSubArrayLen(3, nums));
    }
}
