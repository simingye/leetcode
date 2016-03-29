package MaximumProductSubarray;

/**
 * Created by Siming on 10/28/15.
 */
public class MaximumProductSubarray
{
    public int maxProduct(int[] nums)
    {
        if ( nums==null || nums.length==0 )
            return 0;

        if ( nums.length==1 )
            return nums[0];

        int max_local = nums[0];
        int min_local = nums[0];
        int global = nums[0];

        for (int i=1; i<nums.length; ++i)
        {
            int max_local_copy = max_local;
            max_local = Math.max(Math.max(nums[i] * max_local, nums[i] * min_local), nums[i]);
            min_local = Math.min(Math.min(nums[i] * max_local_copy, nums[i] * min_local), nums[i]);
            global = Math.max(global, max_local);
        }

        return global;
    }

    public static void main(String[] args) {
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] nums = {1,3,-2,4};
        System.out.println(test.maxProduct(nums));
    }
}
