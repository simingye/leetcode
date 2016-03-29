package RemoceDuplicatesFromSortedArrayTwo;

/**
 * Created by SimingYe on 2/10/16.
 */
public class RemoveDuplicatesFromSortedArrayTwo2
{
    public int removeDuplicates(int[] nums)
    {
        if (nums == null)
            return -1;

        if (nums.length == 0 || nums.length == 1)
            return nums.length;

        int limit = 2;
        int count = 1;
        int fast = 1;
        int slow = 1;

        while (fast < nums.length)
        {
            if ((nums[fast-1] == nums[fast] && count < limit))
            {
                if (nums[fast-1] == nums[fast])
                {
                    count++;
                }

                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
            else if ((nums[fast-1] == nums[fast] && count >= limit))
            {
                fast++;
            }
            else if (nums[fast-1] != nums[fast])
            {
                count = 1;
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }

        return slow;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayTwo2 test = new RemoveDuplicatesFromSortedArrayTwo2();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(test.removeDuplicates(nums));
    }
}
