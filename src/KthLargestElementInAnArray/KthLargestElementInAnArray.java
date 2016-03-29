package KthLargestElementInAnArray;

/**
 * Created by Siming on 11/8/15.
 */
public class KthLargestElementInAnArray
{
    public int findKthLargest(int[] nums, int k)
    {
        if (nums == null || nums.length == 0 || k > nums.length)
            return -1;

        return getKth(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    public int getKth(int[] nums, int k, int start, int end)
    {
        int pivot = nums[end];

        int left = start;
        int right = end;

        while (left < right)
        {
            while (left < right && nums[left] < pivot)
            {
                left++;
            }

            while (left < right && nums[right] >= pivot)
            {
                right--;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (left + 1 == k)
        {
            return pivot;
        }
        else if (k < left + 1)
        {
            return getKth(nums, k, start, left - 1);
        }
        else
        {
            return getKth(nums, k, left + 1, end);
        }
    }

    public void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        KthLargestElementInAnArray test = new KthLargestElementInAnArray();
        System.out.println(test.findKthLargest(nums, 2));
    }
}
