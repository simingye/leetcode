package MaximumProductSubarray;

/**
 * Created by SimingYe on 3/16/16.
 */
public class MaximumProductSubarray2
{
    public int maxProduct(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int result = Integer.MIN_VALUE;

        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            max[i] = Math.max(nums[i], Math.max(max[i-1] * nums[i], min[i-1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i-1] * nums[i], min[i-1] * nums[i]));

            result = Math.max(max[i], min[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray2 test = new MaximumProductSubarray2();
        int[] nums = {2,3,-2,4,-8};
        System.out.println(test.maxProduct(nums));
    }
}
