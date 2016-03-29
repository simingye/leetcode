package FindMinimumInRotatedSortedArray;

/**
 * Created by Siming on 10/29/15.
 */
public class FindMinimumInRotatedSortedArray
{
    public int findMin(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        for (int i = 0; i < nums.length - 1; i++)
        {
            if (nums[i] > nums[i + 1])
            {
                return nums[i + 1];
            }
        }

        return nums[0];
    }
}
