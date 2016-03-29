package RemoceDuplicatesFromSortedArrayTwo;

/**
 * Created by Siming on 9/29/15.
 */
public class RemoveDuplicatesFromSortedArrayTwo
{
    public int removeDuplicates(int[] nums)
    {
        int flag = 1;
        int left = 1;
        int right = 1;

        if (nums == null || nums.length == 0)
            return 0;

        while (right < nums.length)
        {
            if (nums[right] != nums[right-1])
            {
                nums[left] = nums[right];
                left++;
                right++;
                flag = 1;

            }
            else
            {
                if (flag < 2)
                {
                    nums[left] = nums[right];
                    left++;
                    right++;
                    flag++;
                }
                else
                {
                    right++;
                    flag++;
                }
            }
        }

        return left;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayTwo test = new RemoveDuplicatesFromSortedArrayTwo();
        int[] nums = {1,1,1,1,2,2,2,2,3,3,3};
        System.out.println(test.removeDuplicates(nums));
    }
}
