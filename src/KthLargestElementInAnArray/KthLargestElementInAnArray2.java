package KthLargestElementInAnArray;

/**
 * Created by SimingYe on 2/21/16.
 */
public class KthLargestElementInAnArray2
{
    public int findKthLargest(int[] nums, int k)
    {
        if (nums == null || nums.length == 0 || k < 1)
            return 0;

        return getKth(nums.length-k+1, nums, 0, nums.length-1);
    }

    public int getKth(int k, int[] nums, int start, int end)
    {
        int pivot = nums[end];

        int left = start;
        int right = end;

        while (left < right)
        {
            while (left < right && nums[left] <= pivot)
            {
                left++;
            }

            while (left < right && nums[right] >= pivot)
            {
                right--;
            }

            if (left < right)
            {
                swap(nums, left, right);
            }
        }

        swap(nums, left, end);

        if (k == left + 1)
        {
            return pivot;
        }
        else if (k < left + 1)
        {
            return getKth(k, nums, start, left-1);
        }
        else
        {
            return getKth(k, nums, left+1, end);
        }
    }

    public void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        KthLargestElementInAnArray2 test = new KthLargestElementInAnArray2();
        System.out.println(test.findKthLargest(nums, 2));
    }
}
