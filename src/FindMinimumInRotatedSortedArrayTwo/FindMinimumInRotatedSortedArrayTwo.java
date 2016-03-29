package FindMinimumInRotatedSortedArrayTwo;

/**
 * Created by Siming on 10/29/15.
 */
public class FindMinimumInRotatedSortedArrayTwo
{
    public int findMin(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int start = 0;
        int end = nums.length - 1;

        while (start < end)
        {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end])
            {
                end = mid;
            }
            else if (nums[mid] > nums[end])
            {
                start = mid + 1;
            }
            else
            {
                end--;
            }
        }

        return nums[start];
    }
}