package KthLargestElementInAnArray;

/**
 * Created by SimingYe on 3/10/16.
 */
public class KthLargestElementInAnArray3
{
    public int kthLargeestElement(int k, int[] nums)
    {
        if (nums == null || nums.length == 0 || k > nums.length)
            return -1;

        return helper(nums, 0, nums.length-1, nums.length+1-k);
    }

    public int helper(int[] nums, int left, int right, int k)
    {
        if (left == right)
            return nums[left];

        int position = partition(nums, left, right);

        if (k == position+1)
        {
            return nums[position];
        }
        else if (k < position+1)
        {
            return helper(nums, left, position-1, k);
        }
        else
        {
            return helper(nums, position+1, right, k);
        }
    }

    public int partition(int[] nums, int left, int right)
    {
        if (left == right)
            return left;

        int pivot = nums[left];
        int i = left;
        int j = right;

        while (i < j)
        {
            while (i < j && nums[j] >= pivot)
            {
                j--;
            }
            nums[i] = nums[j];

            while (i < j && nums[i] <= pivot)
            {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;

        return i;
    }
}
