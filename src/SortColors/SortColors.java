package SortColors;

/**
 * Created by Siming on 9/25/15.
 */
public class SortColors
{
    public void sortColors(int[] nums)
    {
        if (nums == null || nums.length == 0 || nums.length == 1)
        {
            return;
        }

        int left = 0;
        int right = nums.length-1;
        int i = 0;

        while (i < right + 1)
        {
            if (nums[i] == 0)
            {
                swap(nums, i, left);
                left++;
                i++;
                continue;
            }

            if (nums[i] == 2)
            {
                swap(nums, i , right);
                right--;
                continue;
            }

            i++;
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        SortColors test = new SortColors();
        int[] nums = {2,2};
        test.sortColors(nums);
    }
}
