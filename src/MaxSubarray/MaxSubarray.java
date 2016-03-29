package MaxSubarray;

/**
 * Created by Siming on 9/10/15.
 */
public class MaxSubarray
{
    public int maxSubarray(int[] nums)
    {
        int max = 0;
        int result = nums[0];

        for (int i = 0; i < nums.length; i++)
        {
            max = Math.max(nums[i], max + nums[i]);
            result = Math.max(max, result);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSubarray test = new MaxSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubarray(nums));
    }
}
