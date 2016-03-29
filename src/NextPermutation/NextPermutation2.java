package NextPermutation;

/**
 * Created by SimingYe on 1/28/16.
 */
public class NextPermutation2
{
    public void nextPermutation(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return;

        int p = 0;
        int q = 0;
        int temp;

        for (int i = nums.length - 1; i > 0; i--)
        {
            if (nums[i - 1] < nums[i])
            {
                p = i - 1;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--)
        {
            if (nums[p] < nums[i])
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

        temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;

        reverse(nums, p+1, nums.length - 1);

        System.out.println("");
    }

    public void reverse(int[] nums, int first, int last)
    {
        while (first < last)
        {
            int tmp = nums[first];
            nums[first] = nums[last];
            nums[last] = tmp;

            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        NextPermutation2 test = new NextPermutation2();
        int[] nums = {4,5,6,3,2,1};
        test.nextPermutation(nums);
    }
}
