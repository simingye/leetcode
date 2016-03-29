package MinimumSizeSubarraySum;

/**
 * Created by SimingYe on 3/11/16.
 */
public class MinimumSizeSubarraySum2
{
    public int minimumSize(int[] nums, int s)
    {
        if (nums == null || nums.length == 0)
            return -1;

        int i = 0, j = 0;
        int result = Integer.MAX_VALUE;
        int now = 0;

        while (j < nums.length)
        {
            while (j < nums.length && now < s)
            {
                now += nums[j];
                j++;
            }

            while (i <= j && now >= s)
            {
                result = Math.min(result, j-i);
                now -= nums[i];
                i++;
            }
        }

        if (result == Integer.MAX_VALUE)
        {
            return -1;
        }
        else
        {
            return result;
        }
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum2 test = new MinimumSizeSubarraySum2();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(test.minimumSize(nums, 7));
    }
}
