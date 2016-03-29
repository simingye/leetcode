package NextPermutation;

/**
 * Created by Siming on 8/30/15.
 */
public class NextPermutation
{
    public void nextPermutation(int[] nums)
    {
        if (nums.length == 0 || nums.length == 1)
        {
            return;
        }

        int p = 0;
        for (int i = nums.length - 1; i > 0; i--)
        {
            if (nums[i] > nums[i-1])
            {
                p = i - 1;
                break;
            }
        }

        int q = 0;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            if (nums[i] > nums[p])
            {
                q = i;
                break;
            }
        }

        if (p == 0 && q == 0)
        {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int temp;
        temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;

        int left = p + 1;
        int right = nums.length - 1;

        reverse(nums, left, right);
    }

    public void reverse(int[] nums, int left, int right)
    {
        while (left < right)
        {
            int tmp;
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        NextPermutation test = new NextPermutation();
        int[] nums = {1,2,3};
        test.nextPermutation(nums);
        System.out.println(nums);
    }
}
