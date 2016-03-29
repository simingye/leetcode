package FindMinimumInRotatedSortedArray;

/**
 * Created by Siming on 10/29/15.
 */
public class FindMinimumInRotatedSortedArrauSec
{
    int min;
    public int findMin(int[] nums)
    {
        min = nums[0];
        search(nums, 0, nums.length - 1);
        return min;
    }

    public int search(int[] num, int left, int right)
    {
        if (left == right)
            return num[left];

        if ((right - left) == 1)
            return Math.min(num[left], num[right]);

        int middle = left + (right - left) / 2;

        // not rotated
        if (num[left] < num[right])
        {
            return num[left];
        }
        else if (num[middle] > num[left])
        {
            return search(num, middle, right);
        }
        else
        {
            return search(num, left, middle);
        }
    }
}
